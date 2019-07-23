
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class game implements Runnable{
	public static int playerNum = 0;
	private board gameboard;
//	private player serverPlayer;
//	private player clientPlayer;
	private Socket socket;
	private Scanner input;
	//A scanner that scan the inputs from client
	private PrintWriter output;
	
	private boolean client_turn;
	//private Scanner in = new Scanner(System.in);

	//An output stream that direct to the client
	public game(Socket socket) throws IOException
	{
		playerNum++;
		gameboard = new board();
		this.socket = socket;
		this.input = new Scanner(socket.getInputStream());
		this.output = new PrintWriter(socket.getOutputStream(),true);
		
	}
	
	public void run() {
			
		//int mode;//decide pvp or pve 

		//System.out.println(input.nextLine());
		//A new opponent joined...(print welcome info)	
		output.println("This is a tic-tac-toe game\n");
		
		//output.println("REQUEST 1. PvP 2.PvE");
		//mode = input.nextInt();		
		gameMode(2);
		
		
	}
	
	//change gameMode according to user choice
	private void gameMode(int mode) {
		if(mode == 1) {
			//PVP
			PVP();
		}else{
			//PVE
			PVE();
		}
		
	}
	
	private void PVP() {
		
	}
	
	private void PVE() {
		
		try {
			HumanPlayer clientPlayer;
			AIPlayer serverPlayer;
			
			String name;
			output.println("You will play with a AI player");
			//client player
			output.println("NAME");
			name = input.nextLine();
			System.out.println("The opponent's name: "+ name);
			//receive player's name
			
			int counter;//decide who goes first
			output.println("\nFlippin a coin...\n");
			counter = (int)(Math.random() * 2) + 1; // will be 1 or 2
			//1 will be the playerX,2 will be the playerO
			if(counter == 1) {
				clientPlayer = new HumanPlayer(name,global.X);
				serverPlayer = new AIPlayer(global.O);
				client_turn = true;
			}else {
				serverPlayer = new AIPlayer(global.X);
				clientPlayer = new HumanPlayer(name,global.O);
				client_turn = false;
			}
			
			output.println("SYMBOL "+(clientPlayer.returnsym()==global.X?"X":"O"));
			while(gameboard.returnInterState()  == global.E)
			{
				
				if(client_turn)
				{// client's turn
					
					output.println(clientPlayer.returnName()+"'s turn"+" Symbol: "+(clientPlayer.returnsym()==global.X?"X":"O"));			
					//output.println("REQUEST MOVE");
					processCommand(clientPlayer);
					//clientPlayer.play(gameboard);
					
				}else
				{// Server's turn
					//System.out.println("AI's turn");
					output.println(serverPlayer.returnName()+"'s turn"+" Symbol: "+(serverPlayer.returnsym()==global.X?"X":"O"));
					serverPlayer.play(serverPlayer.move(gameboard),gameboard);
					
				}
				client_turn = !client_turn;
				output.println(gameboard.toGUIBoard());
				
				//output.println(gameboard.toString());
			}
			
			if(gameboard.returnInterState() == global.X)
			{
				output.println("GAME: X wins");
			}
			
			if(gameboard.returnInterState() == global.O)
			{
				output.println("GAME: O wins");
			}
			if(gameboard.returnInterState() == global.draw)
			{
				output.println("GAME: Draw");
			}
			
		}catch(NoSuchElementException e) {
			
			System.out.println("Client accidentally quit the session");
			
		}catch(IllegalStateException e){
			
			System.out.println("Client quit the session while in game");
			/*input.close();
			output.close();
			
			try {
				game.playerNum--;
				socket.close();
				System.out.println("One socket closed");
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			//Finally close all the input and output stream
			//disconnect the socket
			
			
			try {
				input.close();
				output.close();
				game.playerNum--;
				socket.close();
				System.out.println("One socket closed");
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	public void processCommand(HumanPlayer player) throws IllegalStateException {
		
		String parseText = input.nextLine();
		System.out.println("Client input: "+ parseText);
		if(parseText.startsWith("INDEX")) {
			int row = Integer.parseInt(parseText.substring(7, 8));
			int col = Integer.parseInt(parseText.substring(9, 10));
			if(gameboard.checkEmpty(row, col)) {
				int[] index = new int[] {row, col};
				player.play(index,gameboard);
			}
		}else {
			client_turn = !client_turn;
		}
			
		if(parseText.startsWith("QUIT")) {
			throw new IllegalStateException();
		}
			
		if(parseText.startsWith("RESTART")) {
			gameboard.clearBoard();
		}
	}
	
	
	//Used in finally{} to catch the final command that user send: only quit or restart
	/*public void processEndCommand() {
		String parseText = "";
		if(input.hasNextLine()) {
			parseText = input.nextLine();
			
		}
		if(parseText.startsWith("QUIT")) {
			System.out.println("Client left");
			output.println("OK");
			
			try {
				game.playerNum--;
				socket.close();
				System.out.println("One socket closed");
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(parseText.startsWith("RESTART")) {
			gameboard.clearBoard();
			gameMode(2);
		}
	}*/
	
	
}
