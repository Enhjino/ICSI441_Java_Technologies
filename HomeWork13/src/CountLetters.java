import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountLetters {
    public CountLetters() {
        readStrings();
    }

    public static String countLetters(String input) {
        return IntStream.range(0, input.length())
                .mapToObj(i -> {
                    char currentChar = input.charAt(i);
                    if (i == 0) {
                        int count = 1;
                        while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                            count++;
                            i++;
                        }
                        if (count == 1) return String.valueOf(currentChar);
                        return count + String.valueOf(currentChar);
                    }
                    if (input.charAt(i) != input.charAt(i - 1)) {
                        int count = 1;
                        while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                            count++;
                            i++;
                        }
                        if (count == 1) return String.valueOf(currentChar);
                        return count + String.valueOf(currentChar);
                    } else {
                        return "";
                    }
                })
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        new CountLetters();
    }

    void readStrings() {
        try {
            File file = new File("src/text.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String inputString = input.next();
                String compressedString = countLetters(inputString);
                System.out.println("Compressed String: " + compressedString);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }
}
