import java.util.Arrays;
import java.util.Comparator;

public class ArraySorting {

    public static void main(String[] args) {
        String[] array1 = {"hello", "spoon", "cat"};
        String[] array2 = {"I", "love", "to", "music"};
        String[] array3 = {"world", "job", "july"};

        String[][] arrays = {array1, array2, array3};

        Arrays.sort(arrays, Comparator.comparingInt(ArraySorting::countWords));

        for (String[] array : arrays) {
            System.out.println(Arrays.toString(array));
        }
    }

    private static int countWords(String[] array) {
        return Arrays.stream(array)
                .mapToInt(word -> word.split("\\s+").length)
                .sum();
    }
}
