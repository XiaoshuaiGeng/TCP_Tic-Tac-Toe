
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class game{
	private board gameboard;
	private player playerAI;
	private player clientPlayer;
	private Scanner input;
	//A scanner that scan the inputs from client
	private PrintWriter output;
	//private Scanner in = new Scanner(System.in);

	//An output stream that direct to the client
	public game(Scanner input,PrintWriter output)
	{
		gameboard = new board();
		this.input = input;
		this.output = output;
		
	}
	
	public void start() {
		
		int counter;
		boolean client_turn;
		String name;
		
		System.out.println(input.nextLine());
		//A new opponent joined...(print welcome info)	
		output.println("This is a tic-tac-toe game\n");
		output.println("You will play with a AI player");
		//client player
		output.println("REQUEST Please enter your name: ");
		name = input.nextLine();
		System.out.println("The opponent's name: "+ name);
		//receive player's name
		
		
		output.println("\nFlippin a coin...\n");
		counter = (int)(Math.random() * 2) + 1; // will be 1 or 2
		//1 will be the playerX,2 will be the playerO
		if(counter == 1) {
			clientPlayer = new HumanPlayer(name,global.X,input,output);
			playerAI = new AIPlayer(global.O);
			client_turn = true;
		}else {
			playerAI = new AIPlayer(global.X);
			clientPlayer = new HumanPlayer(name,global.O,input,output);
			client_turn = false;
		}
		
		System.out.println(playerAI.returnsym());
		while(gameboard.returnInterState()  == global.E)
		{
			if(client_turn)
			{// client's turn
				output.println(clientPlayer.returnName()+"'s turn");			
				clientPlayer.play(gameboard);
				
			}else
			{// AI's turn
				System.out.println("AI's turn");
				output.println(playerAI.returnName()+"'s turn");
				playerAI.play(gameboard);
			
			}
			client_turn = !client_turn;
			output.println(gameboard.toString());
		}
		
		if(gameboard.returnInterState() == global.X)
		{
			output.println("GAME: X wins");
		}
		
		if(gameboard.returnInterState() == global.O)
		{
			output.println("GAME: Y wins");
		}
		if(gameboard.returnInterState() == global.draw)
		{
			output.println("GAME: Draw");
		}
		
	}
	
	
	
}
