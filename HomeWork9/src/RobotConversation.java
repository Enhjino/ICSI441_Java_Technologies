public class RobotConversation {

    public static void main(String[] args) {
        final Robot robot1 = new Robot("Robot 1");
        final Robot robot2 = new Robot("Robot 2");

        Thread thread1 = new Thread(() -> robot1.startConversation(robot2));
        Thread thread2 = new Thread(() -> robot2.startConversation(robot1));

        thread1.start();
        thread2.start();
    }

    static class Robot {
        private final String name;

        public Robot(String name) {
            this.name = name;
        }

        public synchronized void startConversation(Robot otherRobot) {
            System.out.println(name + ": Сайн уу?");
            try {
                wait(); // Wait for other robot to respond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(otherRobot.name + ": Сайн.");
            otherRobot.respond();

            // Continue the conversation...
            System.out.println(name + ": Таны ажил сайн биз дээ ?");
            try {
                wait(); // Wait for other robot to respond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(otherRobot.name + ": Тиймээ сайн. Харин таны ажил сайнуу?");
            otherRobot.respond();

            System.out.println(name + ": Миний ажил маш сайнбайгаа");
            try {
                wait(); // Wait for other robot to respond
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(otherRobot.name + ": Заашгүй дээ.");
            otherRobot.respond();
        }

        public synchronized void respond() {
            notify(); // Notify the waiting robot to continue
            // Continue the conversation...
        }
    }
}
