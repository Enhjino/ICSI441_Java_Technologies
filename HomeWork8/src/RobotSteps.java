public class RobotSteps {
    public static void main(String[] args) {
        Thread leftFootThread = new Thread(() -> {
            while (true) {
                System.out.println("Left");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        Thread rightFootThread = new Thread(() -> {
            while (true) {
                System.out.println("Right");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        leftFootThread.start();
        rightFootThread.start();

        try {
            Thread.sleep(10000);
            leftFootThread.interrupt();
            rightFootThread.interrupt();
            leftFootThread.join();
            rightFootThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
