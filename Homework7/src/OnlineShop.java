import java.util.*;

public class OnlineShop {
    public OnlineShop(){
        Map<String, Map<String, Integer>> buyerData = new TreeMap<>();
        input(buyerData);
        print(buyerData);
    }
    private void input( Map<String, Map<String, Integer>>  buyerData){
        System.out.println("Худалдан авалтын мэдээг өгөгдсөн форматын дагуу оруулна уу:");
        String inputLine;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            inputLine = scanner.nextLine();
            if (inputLine.isEmpty()) {
                break;
            }

            String[] parts = inputLine.split(" ");
            if (parts.length == 3) {
                String buyer = parts[0];
                String item = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                buyerData.putIfAbsent(buyer, new HashMap<>());
                buyerData.get(buyer).merge(item, quantity, Integer::sum);
            }
        }
    }
    private void print(Map<String, Map<String, Integer>> buyerData) {
        for (Map.Entry<String, Map<String, Integer>> buyerEntry : buyerData.entrySet()) {
            String buyer = buyerEntry.getKey();
            Map<String, Integer> items = buyerEntry.getValue();

            System.out.println(buyer + ":");
            items.entrySet().stream()
                    .sorted((itemEntry1, itemEntry2) -> {
                        int result = itemEntry1.getKey().compareTo(itemEntry2.getKey());
                        if (result == 0) {
                            result = itemEntry1.getValue().compareTo(itemEntry2.getValue());
                        }
                        return result;
                    })
                    .forEach(itemEntry -> System.out.println(itemEntry.getKey() + " " + itemEntry.getValue()));
        }
    }

    public static void main(String[] args){
            new OnlineShop();
        }
}
