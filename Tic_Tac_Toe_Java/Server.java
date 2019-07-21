import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * A simple TCP server. When a client connects, it sends the client the current
 * datetime, then closes the connection. This is arguably the simplest server
 * you can write. Beware though that a client has to be completely served its
 * date before the server will be able to handle another client.
 */
public class Server {
	
    public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(59090)) {
            System.out.println("Wait for your opponent...");
            while (true) {
                try (Socket socket = listener.accept()) {
                   PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                   Scanner input = new Scanner(socket.getInputStream());
                   
                   game myGame = new game(input,output);
            	   myGame.start();
                   output.println(new Date().toString());
                }
            }
        }
        
    }
}