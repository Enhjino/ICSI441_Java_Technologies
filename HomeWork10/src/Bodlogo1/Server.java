package Bodlogo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);
    }

    public void listen() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new FileTransferThread(clientSocket).start();
            } catch (IOException e) {
                System.out.println("Error connecting to the client: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server(12345);
            server.listen();
        } catch (IOException e) {
            System.out.println("Error starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class FileTransferThread extends Thread {
    private final Socket clientSocket;

    public FileTransferThread(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
             BufferedOutputStream out = new BufferedOutputStream(clientSocket.getOutputStream())) {

            String fileName = in.readUTF();
            File file = new File(fileName);

            if (file.exists() && !file.isDirectory()) {
                try (FileInputStream fileIn = new FileInputStream(file)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = fileIn.read(buffer)) > 0) {
                        out.write(buffer, 0, bytesRead);
                        out.flush();
                        Thread.sleep(200);
                    }
                }
            } else {
                System.out.println("File not found: " + fileName);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error during file transfer: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

