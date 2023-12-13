package Bodlogo3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int votesForA = 0;
    private int votesForB = 0;
    private int votesReceived = 0;

    public Server(int port, int totalVoters) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);

        while (votesReceived < totalVoters) {
            try {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleClient(socket)).start();
            } catch (IOException e) {
                System.err.println("IO error: " + e.getMessage());
                e.printStackTrace();
            }
        }

        String winner = votesForA > votesForB ? "A" : "B";
        System.out.println("Voting has finished. Candidate " + winner + " wins with " +
                (Math.max(votesForA, votesForB)) + " votes!");

        serverSocket.close();
    }

    private void handleClient(Socket socket) {
        try (DataInputStream input = new DataInputStream(socket.getInputStream())) {
            char vote = input.readChar();
            if (vote == 'A') {
                votesForA++;
            } else if (vote == 'B') {
                votesForB++;
            } else {
                System.out.println("Received wrong vote.");
            }
            votesReceived++;
            System.out.println("Received vote #" + votesReceived + " for Candidate " + vote);
        } catch (IOException e) {
            System.err.println("IO error while handling client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server(5000, 10);
    }
}
