import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A command line client for the date server. Requires the IP address of
 * the server as the sole argument. Exits after printing the response.
 */
public class DateClient {
	
	
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Pass the server IP as the sole command line argument");
            return;
        }
        Socket socket = new Socket(args[0], 59090);
        Scanner input = new Scanner(socket.getInputStream());
        PrintWriter output = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(System.in);
        try {
        	while(input.hasNextLine()) {
        		System.out.println(input.nextLine());
        		output.println(in.nextLine());
        	}
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        System.out.println("Server response: " + in.nextLine());
        
    }
}