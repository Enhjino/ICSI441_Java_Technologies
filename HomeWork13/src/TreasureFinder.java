import java.util.Scanner;

public class TreasureFinder {
    public TreasureFinder() {
        input();
    }
    private void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нийт зүг чигийн тоо:");
        int totalDirections = scanner.nextInt();
        System.out.println("зүг чиг (1-ээс 8 хүртэлх) ба алхамын тоон утгууд (1-ээс 1000 хүртэлх бүхэл тоо) ");
        Coordinates finalCoordinates = processDirections(scanner, totalDirections);
        System.out.printf("Treasure location: (%.3f, %.3f)", finalCoordinates.x(), finalCoordinates.y());
    }
    private static Coordinates processDirections(Scanner scanner, int totalDirections) {
        return java.util.stream.IntStream.range(0, totalDirections)
                .mapToObj(i -> new Direction(scanner.nextInt(), scanner.nextInt()))
                .reduce(new Coordinates(0, 0), TreasureFinder::applyDirection, Coordinates::combine);
    }

    private static Coordinates applyDirection(Coordinates coordinates, Direction direction) {
        return coordinates.move(direction);
    }

    private record Direction(int direction, int steps) {
    }

    private record Coordinates(double x, double y) {

        public Coordinates move(Direction direction) {
            return switch (direction.direction) {
                case 1 -> new Coordinates(x, y + direction.steps);
                case 2 -> new Coordinates(x + direction.steps * Math.cos(Math.PI / 4),
                        y + direction.steps * Math.sin(Math.PI / 4));
                case 3 -> new Coordinates(x + direction.steps, y);
                case 4 -> new Coordinates(x + direction.steps * Math.cos(Math.PI / 4),
                        y - direction.steps * Math.sin(Math.PI / 4));
                case 5 -> new Coordinates(x, y - direction.steps);
                case 6 -> new Coordinates(x - direction.steps * Math.cos(Math.PI / 4),
                        y - direction.steps * Math.sin(Math.PI / 4));
                case 7 -> new Coordinates(x - direction.steps, y);
                case 8 -> new Coordinates(x - direction.steps * Math.cos(Math.PI / 4),
                        y + direction.steps * Math.sin(Math.PI / 4));
                default -> throw new IllegalArgumentException("Буруу зам оруулсан байна.");
            };
        }

        public static Coordinates combine(Coordinates c1, Coordinates c2) {
            return new Coordinates(c1.x() + c2.x(), c1.y() + c2.y());
        }
    }
    public static void main(String[] args) {
        new TreasureFinder();
    }
}
