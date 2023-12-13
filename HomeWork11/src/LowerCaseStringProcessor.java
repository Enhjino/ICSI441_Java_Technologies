import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LowerCaseStringProcessor {

    public static void main(String[] args) {
        String inputString = "Hello World";
        List<String> stringList = Arrays.asList("Java", "Programming", "Lambda", "expression");

        long lowercaseCount = countLowercaseLetters(inputString);
        System.out.println("Number of lowercase letters in the string: " + lowercaseCount);

        String lowercaseString = findStringWithOnlyLowercaseLetters(stringList);
        System.out.println("String containing only lowercase letters in the list: " + lowercaseString);
    }

    private static long countLowercaseLetters(String inputString) {
        return inputString.chars().filter(Character::isLowerCase).count();
    }

    private static String findStringWithOnlyLowercaseLetters(List<String> stringList) {
        Predicate<String> isLowerCaseString = s -> s.chars().allMatch(Character::isLowerCase);

        return stringList.stream()
                .filter(isLowerCaseString)
                .findFirst()
                .orElse("No string with only lowercase letters found");
    }
}
