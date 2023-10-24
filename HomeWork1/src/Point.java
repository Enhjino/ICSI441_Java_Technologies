import java.util.Scanner;

public class Point {

    int x, y;
    public Point(){
        input();
        System.out.println("A(x, y) : ("+x+","+y+")");
        if (x > 0 && y > 0){
            System.out.println("Баруун-дээд муж");
        } else if (x > 0 && y < 0 ) {
            System.out.println("Баруун-доод муж");
        } else if (x < 0 && y > 0){
            System.out.println("Зүүн-дээд муж");
        } else if (x < 0 && y < 0) {
            System.out.println("Зүүн-доод муж");
        }
    }
    void input(){
        Scanner input = new Scanner(System.in);
        System.out.print("x цэгийн координатийг оруул: ");
         x = input.nextInt();
        System.out.print("y цэгийн координатийг оруул: ");
         y = input.nextInt();
         input.close();
    }
    public static void main(String[] args) {
        new Point();
    }
}
