import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateShape {
    File file = null;
    FileOutputStream out;

    public CreateShape() {
        file = new File("naturalNumbers.dat");
        try {
            writeToFile(file);
            List<Integer> coordinates = readCoordinatesFromFile(file);
            List<Line> lines = createLines(coordinates);
            List<Rectangle> rectangles = createRectangles(coordinates);
            for (Rectangle rectangle : rectangles) {
                System.out.println("Rectangle: Width = " + rectangle.getWidth() + ", Height = " + rectangle.getHeight());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> readCoordinatesFromFile(File file) throws IOException {
        FileInputStream fileInput = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInput));

        List<Integer> coordinates = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            int coordinate = Integer.parseInt(line);
            coordinates.add(coordinate);
        }
        br.close();
        return coordinates;
    }
    public List<Rectangle> createRectangles(List<Integer> coordinates) {
        List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < coordinates.size() - 1; i += 2) {
            int width = coordinates.get(i);
            int height = coordinates.get(i + 1);
            if (width > 0 && height > 0) {
                rectangles.add(new Rectangle(width, height));
            }
        }
        return rectangles;
    }
    public List<Line> createLines(List<Integer> coordinates) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i += 2) {
            int x = coordinates.get(i);
            int y = coordinates.get(i + 1);
            lines.add(new Line(x, y));
        }
        return lines;
    }

    void writeToFile(File file) throws IOException {
        out = new FileOutputStream(file);

        Random rand = new Random();

        if (!file.exists()) {
            for (int i = 0; i < 100; i++) {
                out.write(((rand.nextInt(100) + 1) + System.lineSeparator()).getBytes());
            }
        }
        out.close();
    }

    public static void main(String[] args) {
        new CreateShape();
    }
}