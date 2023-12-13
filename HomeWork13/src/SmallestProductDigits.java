import java.util.Scanner;
import java.util.stream.IntStream;

public class SmallestProductDigits {

    private int in;

    public SmallestProductDigits() {
        input();
        int result = findSmallestProduct(in);

        System.out.println(result);
    }

    public static int findSmallestProduct(int n) {
        if (n <= 0) {
            return -1;
        }

        if (n > 10) {
            return IntStream.iterate(10, i -> i <= n * n, i -> i * 10)
                    .filter(num -> {
                        int product = Integer.toString(num)
                                .chars()
                                .map(Character::getNumericValue)
                                .reduce(1, (a, b) -> a * b);
                        return product == n;
                    })
                    .findFirst()
                    .orElse(-1);
        } else {
            return IntStream.rangeClosed(1, Integer.MAX_VALUE)
                    .filter(num -> Integer.toString(num)
                            .chars()
                            .map(Character::getNumericValue)
                            .reduce(1, (a, b) -> a * b) == n)
                    .findFirst()
                    .orElse(-1);
        }
    }

    public static void main(String[] args) {
        new SmallestProductDigits();
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N бүхэл тоо оруул (0 ≤ N ≤ 10^9): ");
        in = scanner.nextInt();
    }
}
