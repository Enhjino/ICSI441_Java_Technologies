import java.util.Scanner;

public class StoreSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalPrice = 0.0;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Product " + i + ":");
            System.out.print("Enter the name of the product: ");
            String productName = scanner.nextLine();

            System.out.print("Enter the price of the product: ");
            double productPrice = scanner.nextDouble();

            scanner.nextLine();

            double totalPurchasePrice = suggestPurchase(productName, productPrice);

            System.out.println("Total purchase price for " + productName + ": $" + totalPurchasePrice);

            totalPrice += totalPurchasePrice;
        }

        System.out.println("\nOverall Total Purchase Price: $" + totalPrice);

        scanner.close();
    }

    private static double suggestPurchase(String itemName, double itemPrice) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How much do you want for " + itemName + "? ");
        double quantity = scanner.nextDouble();

        scanner.nextLine();

        double totalPurchasePrice = quantity * itemPrice;

        return totalPurchasePrice;
    }
}
