
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class game{
	private board gameboard;
	private player playerX;
	private player playerO;
	private Scanner input;
	private PrintWriter output;
	/**
	 * @return initialize a game with two player and one gameboard
	 */
	public game(Scanner input,PrintWriter output)
	{
		this.gameboard = new board();
		this.playerO = null;
		this.playerX = null;
		this.input = input;
		this.output = output;
		int counter,sy;
		String na;
		output.print("Welcome to this program\n");
		
		
		// first player
		output.println("Do you want the player 1 to be \n1.Human Player\t2.AI Player");
		counter = input.nextInt();
		input.nextLine();
		
		
		if(counter == 2)
		{// AI player
			output.println("Which symbol do you want this player has?\n1.X\t2.O");
			sy = input.nextInt();
			if(sy == 1)
			{
				this.playerX = new AIPlayer(global.X);
			}else
			{
				this.playerO = new AIPlayer(global.O);
			}
		}else
		{// human player
			output.println("Please enter player's name");
			na = input.nextLine();
			output.println("Which symbol do you want this player has?\n1.X\t2.O");
			sy = input.nextInt();
			if(sy == 1)
			{
				this.playerX = new HumanPlayer(na, global.X);
			}else
			{
				this.playerO = new HumanPlayer(na, global.O);
			}
		}
		
		// second player
		output.println("Do you want the player 2 to be \n1.Human Player\t2.AI Player");
		counter = input.nextInt();
		input.nextLine();
		if(counter == 2)
		{// AI player
			if(playerX == null)
			{
				this.playerX = new AIPlayer(global.X);
			}else
			{
				this.playerO = new AIPlayer(global.O);
			}
		}else
		{// human player
			output.println("Please enter player's name");
			na = input.nextLine();
			if(playerX == null)
			{
				this.playerX = new HumanPlayer(na, global.X);
			}else
			{
				this.playerO = new HumanPlayer(na, global.O);
			}
		}
		
	}
	
	public void start()
	{
		int counter = (int)Math.random()*2 + 1; // will be 1 or 2
		
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
		}else if(gameboard.returnInterState() == global.O)
		{
			output.println("Y wins");
		}else
		{
			output.println("Draw");
		}
		
	}
}
