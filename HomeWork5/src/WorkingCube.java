import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WorkingCube {
    int M, Mcounts=0;
    ArrayList<Cube> cubes = new ArrayList<>();
    File file = new File("src\\cubes.dat");
    WorkingCube() throws IOException, ClassNotFoundException {
        cubes.add(new Cube(12, "ногоон", "төмөр"));
        cubes.add(new Cube(23, "шар", "модон"));
        cubes.add(new Cube(5, "улаан", "цаасан"));
        cubes.add(new Cube(2, "ногоон", "модон"));
        cubes.add(new Cube(6, "цэнхэр", "төмөр"));
        input();
        addToFile();
        Map<String, Integer> colorCounts = findColorCounts();
        System.out.println("Өнгө тус бүрийн шоо:");
        for (Map.Entry<String, Integer> entry : colorCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\n");
        for(Cube cube:findWoodCubes()){
            System.out.println("Хэмжээ : "+cube.size);
            System.out.println("Өнгө : "+cube.color);
            System.out.println("Материал : "+cube.material);
        }

        System.out.println(M + " урттай модон шоо "+Mcounts+" байна.");
        System.out.println("\n");
        String mostCommonColor = findMostCommonColor(colorCounts);
        System.out.println("Хамгийн олон байгаа өнгийн шоо : " + mostCommonColor);

    }
    void input(){
        Scanner in = new Scanner(System.in);
        System.out.print(" M ирмэгийн урт:");
        M = in.nextInt();
        in.close();
    }

    void addToFile() throws IOException {
        ObjectOutputStream obOut=new ObjectOutputStream(new FileOutputStream(file));
        for(Cube cube:cubes){
            obOut.writeObject(cube);
        }
        obOut.close();
    }
    Map<String, Integer> findColorCounts() throws IOException, ClassNotFoundException {
        ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(file));
        Map<String, Integer> colorCounts = new HashMap<>();
        Cube temp;
        while (true) {
            try {
                temp = (Cube) obIn.readObject();
                String color = temp.color;
                colorCounts.put(color, colorCounts.getOrDefault(color, 0) + 1);
            } catch (EOFException e) {
                break;
            }
        }
        obIn.close();
        return colorCounts;
    }

    ArrayList<Cube> findWoodCubes() throws IOException, ClassNotFoundException {
        ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(file));
        ArrayList<Cube> findings = new ArrayList<>();
        Cube temp;
        while (true) {
            try {
                temp = (Cube) obIn.readObject();
                if (M == temp.size && temp.material.equals("модон")) {
                    findings.add(temp);
                }
            } catch (EOFException e) {
                break;
            }
        }
        obIn.close();
        return findings;
    }
    String findMostCommonColor(Map<String, Integer> colorCounts) {
        int maxCount = 0;
        String mostCommonColor = null;
        for (Map.Entry<String, Integer> entry : colorCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonColor = entry.getKey();
            }
        }
        return mostCommonColor;
    }
    public static void main(String[] args) {
        try {
            new WorkingCube();
        } catch ( ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}