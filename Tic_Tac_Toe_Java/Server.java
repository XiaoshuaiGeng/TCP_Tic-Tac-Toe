import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            ExecutorService pool = Executors.newCachedThreadPool();
            while (true) {
                try {  
                	
                   pool.execute(new game(listener.accept()));
                   System.out.println("\nCurrent Player #: "+game.playerNum+"\n");
                }catch(NoSuchElementException e){
                	System.out.println("The client player has invalid input");

                
                }catch(Exception e) {
                	e.printStackTrace();
                	
                }finally {
                	System.out.println("Creating another thread");
                	
                }
            }
        }
        
    }

}