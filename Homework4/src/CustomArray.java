import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomArray {
    private int[] array;
    private int size;
    public CustomArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Массивын хэмжээ сөрөг байж болохгүй.");
        }
        array = new int[capacity];
        size = 0;
    }
    public CustomArray() {
        this(10);
    }

    public void add(int num1, int num2) {
        if (size + 2 > array.length) {
            throw new ArithmeticException("OVERFLOW");
        }

        if (size + 2 > array.length) {
            int[] newarray = new int[array.length * 2];
            System.arraycopy(array, 0, newarray, 0, array.length);
            array = newarray;
        }

        array[size++] = num1;
        array[size++] = num2;
    }

    public int at(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс хязгаараас давсан байна.");
        }
        return array[index];
    }

    public static void main(String[] args) {
        try {
            System.out.println("Массив хэдэн элементтэй вэ?");
            Scanner in = new Scanner(System.in);
            int capacity = in.nextInt();
            CustomArray customArray = new CustomArray(capacity);
            customArray.add(42, 56);
            customArray.add(42, 56);
            int element = customArray.at(0);
            if (element != -1) {
                System.out.println("0 дэх элемент: " + element);
            }
            System.out.println("Хэд дэх элементийг харах вэ?");
            int arrayAt = in.nextInt();
            if (element != -1) {
                System.out.println(arrayAt+" дэх элемент: " +  customArray.at(arrayAt));
            }
        }catch (InputMismatchException ex){
            System.out.println(ex.getMessage());
        }catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }

    }
}
