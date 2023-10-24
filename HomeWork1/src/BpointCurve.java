import java.util.Scanner;

public class BpointCurve {
    double x,y;
    public BpointCurve(){
        input();
        System.out.println("B(x, y) : ("+x+","+y+")");
        double fx = 6 * Math.pow(Math.cos(x), 2) - 0.25 * Math.pow(x, 5) + 32 * Math.pow(x, 2) - 27;
        if (Math.abs(y - fx) < 1e-3) {
            System.out.println(" B(" + x + ", " + y + ") цэг нь f(x)=6cos^2(x)−0.25x^5+32x^2−27 муруйд оршино");
        } else {
            System.out.println(" B(" + x + ", " + y + ") цэг нь f(x)=6cos^2(x)−0.25x^5+32x^2−27 муруйд оршихгүй");
        }
    }
    void input(){
        Scanner input = new Scanner(System.in);
        System.out.print("x цэгийн координатийг оруул: ");
        x = input.nextDouble();
        System.out.print("y цэгийн координатийг оруул: ");
        y = input.nextDouble();
        input.close();
    }
    public static void main (String[] args ){
        new BpointCurve();
    }
}
