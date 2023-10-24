import java.io.*;
import java.util.*;
public class FindSpringMonths {
    public FindSpringMonths(){
        System.out.println("Хаварын сарууд : ");
        readFile();
    }
   void readFile(){
       try {
           File file = new File("src//text.txt");
           Scanner input = new Scanner(file);
           while (input.hasNext()) {
               String date = input.next();
               int month = splitMonth(date);
               if(isSpringMonth(month)){
                   System.out.println(date);
               }
           }
           input.close();
       } catch (FileNotFoundException e) {
           System.out.println("Алдаа гарлаа");
           e.printStackTrace();
       }
   }
    public int splitMonth(String string) {
        String[] date1 = string.split("-");
        if (date1.length == 3) {
            return Integer.parseInt(date1[1]);
        }
        return 0;
    }
    private static boolean isSpringMonth(int month) {
        return (month >= 3 && month <= 5);
    }
    public static void main(String[] args) {
        new FindSpringMonths();
    }
}
