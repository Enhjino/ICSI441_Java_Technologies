package Bodlogo1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private DataOutputStream out;
    private BufferedInputStream in;

    public Client(String address, int port) throws IOException {
        try {
            socket = new Socket(address, port);
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            in = new BufferedInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("Error creating client: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void requestFile(String fileName) throws IOException {
        try {
            out.writeUTF(fileName);
            out.flush();
        } catch (IOException e) {
            System.err.println("Error sending file request: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void close() {
        try {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = null;
        try {
            client = new Client("localhost", 5000);
            client.requestFile("example.txt");
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        } finally {
            if (client != null) {
                client.close();
            }
        }
    }
}
