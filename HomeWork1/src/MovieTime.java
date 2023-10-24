import java.util.Scanner;

public class MovieTime {
    int number, hour,regularPrice;
    double discountPercentage,discountedPrice;
    String RoomName;
    public MovieTime(){
        input();
        calculatePrice();
        System.out.println("\nТаны захиалга");
        System.out.println("Танхим: " + RoomName);
        System.out.println("Үзвэр цаг: " +hour+ " цаг");
        System.out.println("Хямдрал: " + (discountPercentage*100) + "%");
        System.out.println("Үзвэр үнэ: $" +regularPrice );
        System.out.println("Тасалбарын тоо: " + number);
        System.out.println("Тасалбарын үнэ: $" + discountedPrice);
    }
    void calculatePrice(){
        switch (RoomName) {
            case "Улаан" -> {
                switch (hour) {
                    case 12 -> regularPrice = 2500;
                    case 16 -> regularPrice = 3500;
                    case 20 -> regularPrice = 4500;
                    default -> {
                        System.out.println("Та буруу цаг оруулсан байна");
                        System.exit(1);
                    }
                }
            }
            case "Хөх" -> {
                switch (hour) {
                    case 10 -> regularPrice = 2500;
                    case 13 -> regularPrice = 3500;
                    default -> {
                        System.out.println("Та буруу цаг оруулсан байна");
                        System.exit(1);
                    }
                }
            }
            case "Ногоон" -> {
                switch (hour) {
                    case 10 -> regularPrice = 3500;
                    case 14, 18 -> regularPrice = 4500;
                    default -> {
                        System.out.println("Та буруу цаг оруулсан байна");
                        System.exit(1);
                    }
                }
            }
            default -> {
                System.out.println("Та буруу танхим оруулсан байна.");
                System.exit(1);
            }
        }
        if (number >= 5 ){
            if (number >= 10) {
                discountPercentage = 0.1;
            }else {
                discountPercentage = 0.05;
            }
        }else {
            discountPercentage = 0;
        }
        if(number != 0 ){
            discountedPrice = regularPrice*number - (regularPrice*number*discountPercentage);
        }else {
            discountedPrice = regularPrice ;
        }
    }
    void input(){
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Кино үзэх танхим: (Улаан,Хөх,Ногоон)\n");
            RoomName = input.nextLine();

            if (isValidRoom(RoomName)) {
                break;
            } else {
                System.out.println("Та буруу танхим оруулсан байна. Дахин оруулна уу.");
            }
        }
        System.out.print("Кино үзэх цаг: Улаан(12, 16, 20), Хөх(10, 13), Ногоон(10, 14, 18) \n");
        hour = input.nextInt();
        System.out.print("Тасалбарын тоо: ");
        number = input.nextInt();
        input.close();
    }
    private static boolean isValidRoom(String roomName) {
        return roomName.equals("Улаан") || roomName.equals("Хөх") || roomName.equals("Ногоон");
    }

    public static void main(String[] arg){
        new MovieTime();
    }
}
