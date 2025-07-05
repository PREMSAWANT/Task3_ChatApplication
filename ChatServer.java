import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ChatServer - Server for a multithreaded group chat application.
 * Accepts multiple clients and broadcasts messages to all connected users.
 */
public class ChatServer {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clientHandlers = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Study Group Chat Server started on port " + PORT);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                clientHandlers.add(handler);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Broadcast a message to all clients
    public static void broadcast(String message, ClientHandler sender) {
        synchronized (clientHandlers) {
            for (ClientHandler handler : clientHandlers) {
                if (handler != sender) {
                    handler.sendMessage(message);
                }
            }
        }
    }

    // Remove a client from the set
    public static void removeClient(ClientHandler handler) {
        clientHandlers.remove(handler);
    }

    // Inner class to handle each client
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String userName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Enter your name:");
                userName = in.readLine();
                System.out.println(userName + " joined the chat.");
                broadcast(userName + " has joined the chat!", this);
                String msg;
                while ((msg = in.readLine()) != null) {
                    if (msg.equalsIgnoreCase("/quit")) {
                        break;
                    }
                    String formattedMsg = userName + ": " + msg;
                    System.out.println(formattedMsg);
                    broadcast(formattedMsg, this);
                }
            } catch (IOException e) {
                System.out.println("Connection error with client: " + e.getMessage());
            } finally {
                try { socket.close(); } catch (IOException ignored) {}
                removeClient(this);
                System.out.println(userName + " left the chat.");
                broadcast(userName + " has left the chat.", this);
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
} 