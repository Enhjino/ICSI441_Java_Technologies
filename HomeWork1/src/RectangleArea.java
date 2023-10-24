public class RectangleArea {
    double length1 = 2, width1 = 2;
    double length2 , width2;

    public RectangleArea(){
        length2 = Math.sqrt(Math.pow(length1/2,2) +Math.pow(width1/2,2));
        width2 = Math.sqrt(Math.pow(length1/2,2) +Math.pow(width1/2,2));
        int bigArea = (int) (length1 * width1);
        int smallArea = (int) Math.round(length2 * width2);
        System.out.println("Zuragt durslegdsen mujiin talbai: " + (bigArea - smallArea)+" baina");
    }

    public static void main(String[] args) {
        new RectangleArea();
    }
}