package Bodlogo3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 5000;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Give your vote (A or B):");
            String vote = scanner.nextLine();

            if (isValidVote(vote)) {
                try (Socket socket = new Socket(serverAddress, serverPort);
                     DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

                    output.writeChar(vote.toUpperCase().charAt(0));
                    output.flush();
                    System.out.println("Vote for Candidate " + vote.toUpperCase() + " sent to the server.");
                } catch (IOException e) {
                    System.err.println("Error sending vote to the server: " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid vote. Please vote for either 'A' or 'B'.");
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean isValidVote(String vote) {
        return vote != null && (vote.equalsIgnoreCase("A") || vote.equalsIgnoreCase("B"));
    }
}
