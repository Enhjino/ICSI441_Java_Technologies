import java.util.ArrayList;
import java.util.List;
abstract class Furniture {
    private int numberOfLegs;
    private double height;
    private double width;
    private double depth;
    private boolean sittable;
    private double price;
    private String style;
    public Furniture(int numberOfLegs, double height, double width, double depth, boolean sittable, double price, String style) {
        this.numberOfLegs = numberOfLegs;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.sittable = sittable;
        this.price = price;
        this.style = style;
    }
    public abstract String getName();
    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public boolean issittable() {
        return sittable;
    }

    public double getPrice() {
        return price;
    }

    public String getStyle() {
        return style;
    }
}
class Chair extends Furniture {
    public Chair(double height, double width, double depth, boolean sittable, double price, String style) {
        super(4, height, width, depth, sittable, price, style);
    }

    @Override
    public String getName() {
        return "Сандал";
    }
}
class Table extends Furniture {
    public Table(double height, double width, double depth, boolean sittable, double price, String style) {
        super(4, height, width, depth, sittable, price, style);
    }

    @Override
    public String getName() {
        return "Ширээ";
    }
}
class Bed extends Furniture {
    public Bed(double height, double width, double depth, boolean sittable, double price, String style) {
        super(4, height, width, depth, sittable, price, style);
    }
    @Override
    public String getName() {
            return "Ор";
    }
}
class FurnitureStore {
    private List<Furniture> inventory;

    public FurnitureStore() {
        this.inventory = new ArrayList<>();
    }
    public void addFurniture(Furniture furniture) {
        inventory.add(furniture);
    }
    public void printInventory() {
        for (Furniture furniture : inventory) {
            System.out.println("Нэр: " + furniture.getName());
            System.out.println("Хөлний тоо: " + furniture.getNumberOfLegs() +" ш");
            System.out.println("Өндөр: " + furniture.getHeight()+ " см");
            System.out.println("Өргөн: " + furniture.getWidth() + " см");
            System.out.println("Гүн: " + furniture.getDepth() + " см");
            if ( furniture.issittable()) {
                System.out.println("Суух боломжтой эсэх: Тийм");
            } else {
                System.out.println("Суух боломжтой эсэх: Үгүй");
            }
            System.out.println("Үнэ: " + furniture.getPrice() + " мянган төгрөг");
            System.out.println("Загвар: " + furniture.getStyle());
            System.out.println();
        }
    }
}

public class bodlogo1 {
    public static void main(String[] args) {
        FurnitureStore store = new FurnitureStore();

        Chair chair = new Chair(30, 20, 20, true, 50.0, "Түшлэгтэй");
        Table table = new Table(30, 40, 40, false, 100.0, "Дугуй");
        Bed bed = new Bed(40, 80, 60, true, 200.0, "Хүүхдийн");
        store.addFurniture(chair);
        store.addFurniture(table);
        store.addFurniture(bed);
        store.printInventory();
    }
}
