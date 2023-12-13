import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSequences {
    int n;

    public TwoSequences() {
        input();
        List<Integer> defaultAnSequence = generateDefaultAnSequence();
        List<Integer> bnSequence = generateBnSequence(defaultAnSequence);
        List<Integer> anSequence = new ArrayList<>(defaultAnSequence);

        while (anSequence.size() < n) {
            int nextAnElement = bnSequence.get(anSequence.size() - 1) + bnSequence.get(anSequence.size() - 3);
            anSequence.add(nextAnElement);
            bnSequence = generateBnSequence(anSequence);
        }
        System.out.println("an Sequence: " + anSequence);
        System.out.println("bn Sequence: " + bnSequence);

        int nthElement = n;
        System.out.println("a дарааллын " + nthElement + " дахь элемент нь: " + findNthElement(anSequence, nthElement));
        System.out.println("b дарааллын " + nthElement + " дахь элемент нь:" + findNthElement(bnSequence, nthElement));
    }

    private static List<Integer> generateDefaultAnSequence() {
        return List.of(2, 3, 4, 7, 13);
    }

    private static List<Integer> generateBnSequence(List<Integer> anSequence) {
        return IntStream.iterate(1, i -> i <= anSequence.get(anSequence.size() - 1), i -> i + 1)
                .filter(i -> !anSequence.contains(i))
                .boxed()
                .collect(Collectors.toList());
    }

    private static int findNthElement(List<Integer> sequence, int n) {
        return sequence.get(n - 1);
    }

    private static int getLastElement(List<Integer> sequence) {
        return sequence.get(sequence.size() - 1);
    }

    public static void main(String[] args) {
        new TwoSequences();
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n (1 ≤ n ≤ 10000):");
        n = scanner.nextInt();
    }
}
