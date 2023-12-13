import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class MostWordsLineFinder {
    public static void main(String[] args) {
        try {
            Path filePath = Path.of("input.txt");

            List<String> lines = Files.readAllLines(filePath);

            List<String> linesWithMostWords = lines.stream()
                    .max(Comparator.comparingInt(line -> countWords(line)))
                    .map(List::of)
                    .orElse(List.of());

            System.out.println("Line(s) with the most words:");
            linesWithMostWords.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(String line) {
        return line.split("\\s+").length;
    }
}
