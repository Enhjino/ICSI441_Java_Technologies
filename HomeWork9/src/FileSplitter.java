import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FileSplitter {

    public static void main(String[] args) {
        String inputFilePath = "src\\students.dat";  // Adjust the input file path
        Path outputPath = Paths.get("output");  // Adjust the output directory path

        FileSplitterTask fileSplitterTask = new FileSplitterTask(Paths.get(inputFilePath), outputPath);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fileSplitterTask);
    }

    static class FileSplitterTask extends RecursiveTask<Void> {
        private static final int THRESHOLD = 1000; // Adjust the threshold as needed
        private final Path inputFilePath;
        private final Path outputDirectory;

        public FileSplitterTask(Path inputFilePath, Path outputDirectory) {
            this.inputFilePath = inputFilePath;
            this.outputDirectory = outputDirectory;
        }

        @Override
        protected Void compute() {
            try {
                List<Student> students = readStudentsFromFile(inputFilePath);

                if (students.size() <= THRESHOLD) {
                    writeStudentsToFile(students, outputDirectory.resolve("output1.dat"));
                } else {
                    int mid = students.size() / 2;

                    FileSplitterTask task1 = new FileSplitterTask(inputFilePath, outputDirectory);
                    task1.fork();

                    FileSplitterTask task2 = new FileSplitterTask(inputFilePath, outputDirectory);
                    task2.compute();

                    task1.join();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private List<Student> readStudentsFromFile(Path filePath) throws IOException {
            List<Student> students = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
                while (true) {
                    try {
                        Student student = (Student) ois.readObject();
                        students.add(student);
                    } catch (EOFException e) {
                        break;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            return students;
        }

        private void writeStudentsToFile(List<Student> students, Path outputPath) throws IOException {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath.toFile()))) {
                for (Student student : students) {
                    oos.writeObject(student);
                }
            }
        }
    }

    static class Student implements Serializable {
        String name;
        String id;
        String address;
        double cgpa;

        // Constructor, getters, and setters
    }
}
