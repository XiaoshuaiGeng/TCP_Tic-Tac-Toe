
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class game{
	private board gameboard;
	private player playerX;
	private player playerO;
	private Scanner input;
	//A scanner that scan the inputs from client
	private PrintWriter output;
	private Scanner in = new Scanner(System.in);

	//An output stream that direct to the client
	public game(Scanner input,PrintWriter output)
	{
		gameboard = new board();
		this.input = input;
		this.output = output;
		
	}
	
	public void start() {
		
		int counter,sy;
		boolean client_turn;
		String name;
		
		System.out.println(input.nextLine());
		//A new opponent joined...(print welcome info)	
		output.println("This is a tic-tac-toe game\n");
		output.println("You will play with a AI player");
		//client player
		output.println("Please enter your name: ");
		name = input.nextLine();
		//receive player's name
		
		
		output.println("\nFlippin a coin...\n");
		counter = (int)Math.random()*2 + 1; // will be 1 or 2
		//1 will be the playerX,2 will be the playerO
		if(counter == 1) {
			playerX = new HumanPlayer(name,global.X);
			playerO = new AIPlayer(global.O);
			client_turn = true;
		}else {
			playerX = new AIPlayer(global.O);
			playerO = new HumanPlayer(name,global.X);
			client_turn = false;
		}
		
		int row, col;
		
		while(gameboard.returnInterState()  == global.E)
		{
			if(client_turn)
			{// client's turn
				output.println(playerX.returnName()+"'s turn");
				
				output.println("Please enter x-axis (row):  (0, 1, 2)");
				row = input.nextInt();
				
				output.println("Please enter y-axis (col)");
				col = input.nextInt();
				
				
				playerX.play(gameboard);
				output.println("");
				counter = 2;
				output.println(gameboard+"\n");
			}else
			{// AI's turn
				output.println(playerO.returnName()+"'s turn");
				playerO.play(gameboard);
				output.println("");
				counter = 1;
				output.println(gameboard+"\n");
			}
		}
		
		if(gameboard.returnInterState() == global.X)
		{
			output.println("X wins");
		}
		
		if(gameboard.returnInterState() == global.O)
		{
			output.println("Y wins");
		}
		if(gameboard.returnInterState() == global.draw)
		{
			output.println("Draw");
		}
		
	}
	
	/*public void start2()
	{
		
		
		while(gameboard.returnInterState()  == global.E)
		{
			if(counter == 1)
			{// playerX goes first
				output.println(playerX.returnName()+" is playing");
				playerX.play(gameboard);
				output.println("");
				counter = 2;
				output.println(gameboard+"\n");
			}else
			{// playerO goes first
				output.println(playerO.returnName()+" is playing");
				playerO.play(gameboard);
				output.println("");
				counter = 1;
				output.println(gameboard+"\n");
			}
		}
		
		if(gameboard.returnInterState() == global.X)
		{
			output.println("X wins");
		}
		
		if(gameboard.returnInterState() == global.O)
		{
			output.println("Y wins");
		}
		if(gameboard.returnInterState() == global.draw)
		{
			output.println("Draw");
		}
		
	}*/
	
	
}
