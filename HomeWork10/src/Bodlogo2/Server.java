package Bodlogo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 5000;
        try (Socket socket = new Socket(serverAddress, serverPort)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter first number: ");
            int number1 = scanner.nextInt();
            System.out.println("Enter second number: ");
            int number2 = scanner.nextInt();
            System.out.println("Enter operator (+, -, *, /, %): ");
            char operation = scanner.next().charAt(0);

            output.writeInt(number1);
            output.writeInt(number2);
            output.writeChar(operation);
            output.flush();

            int result = input.readInt();
            if (result == Integer.MAX_VALUE && (operation == '/' || operation == '%')) {
                System.out.println("Error: Division by zero");
            } else {
                System.out.println("Result: " + result);
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}