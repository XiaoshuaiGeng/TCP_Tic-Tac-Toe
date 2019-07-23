import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintWriter;



public class Client{
	
	public PrintWriter output;
	public GUI_board board;
	public Socket socket;
	public Scanner input;
	private String name;
	private String symbol;
	private boolean gameEnd;

	public Client(GUI_board board,String name) throws UnknownHostException, IOException {
		this.board = board;
		setName(name);
		this.socket = new Socket("localhost", 59090);
		this.gameEnd = false;
		this.input = new Scanner(socket.getInputStream());
	    this.output = new PrintWriter(socket.getOutputStream(),true);
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
	
	public void setBoard(String command) {
		for(int i=6; i<command.length();i++) {
			// index start from 6 after "BOARD "
			if(i>=6 && i <9) 
				board.buttons[0][i-6].setMark(command.substring(i,i+1));

			if(i>=9 && i<12) 
				board.buttons[1][i-9].setMark(command.substring(i,i+1));
			
			if(i>=12) 
				board.buttons[2][i-12].setMark(command.substring(i,i+1));
		}
	}
	
	public void run() {
		while(isGameEnd()!=true && input.hasNextLine()) {
			//System.out.println(getName());
			//System.out.println(getSymbol());
			//board.unlockBoard();
			String command;
			command = input.nextLine();
			System.out.println(command);
			if(command.startsWith("BOARD")) {
				//System.out.println("set mark!");
				setBoard(command);
			}
			else if(command.startsWith("GAME")) {
				setGameEnd(true);
				//board.clearBoard();
				board.lockBoard();
			}
			else if(command.startsWith("SYMBOL")) {
				setSymbol(command.substring(7,8));
			}
			else if(command.startsWith("NAME")) {
				output.println(getName());
			}
		}
		System.out.println("Game End");
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
		return this.gameEnd;
	}
	public void setSymbol(String sym) {
		this.symbol=sym;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	
}