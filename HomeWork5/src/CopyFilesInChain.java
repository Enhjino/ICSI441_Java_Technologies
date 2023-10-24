import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CopyFilesInChain {

    public static void writeRandToFile(File file) throws IOException {
        Random rand = new Random();
        try (FileOutputStream out = new FileOutputStream(file)) {
            if (file.exists()) {
                for (int i = 0; i < 10; i++) {
                    out.write(rand.nextInt(100));
                }
            }
        }
    }
    public static void copyFile(String sourceFileName, String targetFileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourceFileName);
        FileOutputStream outputStream = new FileOutputStream(targetFileName);

        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();
    }
    public static void main(String[] args) {
        String[] sourceFileNames = {"f1.dat", "f2.dat", "f3.dat", "f4.dat", "f5.dat"};

        try {
            for (String fileName : sourceFileNames) {
                File file = new File(fileName);
                writeRandToFile(file);
                System.out.println("File " + fileName + " filled with random numbers.");
            }
            for (int i = 0; i < sourceFileNames.length; i++) {
                String sourceFileName = sourceFileNames[i];
                String targetFileName = sourceFileNames[(i + 1) % sourceFileNames.length];
                copyFile(sourceFileName, targetFileName);
                System.out.println(sourceFileName + " copied to " + targetFileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
