import java.util.Random;

public class GuessingNumbersGame {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new GuessingThread()).start();
        }
    }

    static class GuessingThread implements Runnable {
        private static final int MAX_ATTEMPTS = 5;
        private static final int TARGET_NUMBER = new Random().nextInt(100);

        @Override
        public void run() {
            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                int guess = new Random().nextInt(100);
                if (guess == TARGET_NUMBER) {
                    System.out.println("Guessed " + TARGET_NUMBER + " in " + attempt + " attempts.");
                    return;
                }
                System.out.println("Attempt " + attempt + ": Guessed " + guess);
            }
            System.out.println("Failed to guess " + TARGET_NUMBER + " in " + MAX_ATTEMPTS + " attempts.");
        }
    }
}
