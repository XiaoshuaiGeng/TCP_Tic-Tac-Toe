import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintWriter;



public class Client{
	
	boolean gameStart = false;
	public PrintWriter output;
	public GUI_board board;
	public Socket socket;
	public Scanner input;
	private String name;
	private String symbol;
	private boolean gameEnd;
	
	public Client(GUI_board board) throws IOException{
		this.board = board;
		//this.name = name;
		this.socket = new Socket("10.242.62.138", 59090);
		
		this.gameEnd = false;
		input = new Scanner(socket.getInputStream());
	    output = new PrintWriter(socket.getOutputStream(),true);
	} 
	
	public void quit() throws IOException {
		if(!gameEnd)
			output.println("QUIT");
		input.close();
    	output.close();
    	socket.close();
	}
	
	public void sendIndex(String index) {
		output.println(index);
	}
	public void sendName(String name) {
		output.println(name);
	}
	
	public void setBoard(String command) {
		for(int i=6; i<command.length();i++) {
			// index start from 6 after "BOARD "
			if(i>=6 && i <9) 
				board.buttons[0][i-6].setText(command.substring(i,i+1));

			if(i>=9 && i<12) 
				board.buttons[1][i-9].setText(command.substring(i,i+1));
			
			if(i>=12) 
				board.buttons[2][i-12].setText(command.substring(i,i+1));
		}
	}
	
	public void run() throws Exception{
		//board.lockBoard();
		
		//output.println(getName());
		while(input.hasNextLine()) {
			String command;
			command = input.nextLine();
			System.out.println(command);
			if(command.startsWith("BOARD")) {
				setBoard(command);
			}
			else if(command.startsWith("GAME")) {
				setGameEnd(true);
			}
			else if(command.startsWith("SYMBOL")) {
				setSymbol(command.substring(6,7));
			}
//			else if(command.startsWith("NAME")) {
//				output.println(getName());
//			}
		}
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGameEnd(boolean end) {
		gameEnd = end;
	}
	
	public boolean isGameEnd() {
		return gameEnd;
	}
	public void setSymbol(String sym) {
		symbol=sym;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	
	
}