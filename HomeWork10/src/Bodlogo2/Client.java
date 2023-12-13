package Bodlogo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server assan port " + port);

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                int number1 = input.readInt();
                int number2 = input.readInt();
                char operation = input.readChar();

                int result;
                switch (operation) {
                    case '+': result = number1 + number2; break;
                    case '-': result = number1 - number2; break;
                    case '*': result = number1 * number2; break;
                    case '/': result = number2 != 0 ? number1 / number2 : Integer.MAX_VALUE; break;
                    case '%': result = number2 != 0 ? number1 % number2 : Integer.MAX_VALUE; break;
                    default: throw new IllegalArgumentException("Wrong operator: " + operation);
                }

                output.writeInt(result);
            } catch (IOException e) {
                System.err.println("IO error " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Argument error " + e.getMessage());
            }
        }
    }
}