public class CharacterPrintingThreads {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CharacterPrinter('A'));
        Thread thread2 = new Thread(new CharacterPrinter('C'));
        Thread thread3 = new Thread(new CharacterPrinter('E'));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class CharacterPrinter implements Runnable {
        private char character;

        public CharacterPrinter(char character) {
            this.character = character;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.print(character);

                character += 3;

                if (character > 'Z') {
                    character = (char) (character - 'Z' + 'A' - 1);
                }
            }
        }
    }
}
