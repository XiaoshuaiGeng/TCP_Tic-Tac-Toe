
import java.util.Scanner;

public class game implements global{
	private board gameboard;
	private player playerX;
	private player playerO;
	private Scanner s = new Scanner(System.in);
	
	
	/**
	 * @return initialize a game with two player and one gameboard
	 */
	public game()
	{
		this.gameboard = new board();
		this.playerO = null;
		this.playerX = null;
		
		int counter,sy;
		String na;
		System.out.println("Welcome to this program.");
		
		
		// first player
		System.out.println("Do you want the player 1 to be \n1.Human Player\t2.AI Player");
		counter = s.nextInt();
		s.nextLine();
		if(counter == 2)
		{// AI player
			System.out.println("Which symbol do you want this player has?\n1.X\t2.O");
			sy = s.nextInt();
			if(sy == 1)
			{
				this.playerX = new AIPlayer(X);
			}else
			{
				this.playerO = new AIPlayer(O);
			}
		}else
		{// human player
			System.out.println("Please enter player's name");
			na = s.nextLine();
			System.out.println("Which symbol do you want this player has?\n1.X\t2.O");
			sy = s.nextInt();
			if(sy == 1)
			{
				this.playerX = new HumanPlayer(na, X);
			}else
			{
				this.playerO = new HumanPlayer(na, O);
			}
		}
		
		// second player
		System.out.println("Do you want the player 2 to be \n1.Human Player\t2.AI Player");
		counter = s.nextInt();
		s.nextLine();
		if(counter == 2)
		{// AI player
			if(playerX == null)
			{
				this.playerX = new AIPlayer(X);
			}else
			{
				this.playerO = new AIPlayer(O);
			}
		}else
		{// human player
			System.out.println("Please enter player's name");
			na = s.nextLine();
			if(playerX == null)
			{
				this.playerX = new HumanPlayer(na, X);
			}else
			{
				this.playerO = new HumanPlayer(na, O);
			}
		}
		
	}
	
	public void start()
	{
		int counter = (int)Math.random()*2 + 1; // will be 1 or 2
		
		while(gameboard.returnInterState()  == E)
		{
			if(counter == 1)
			{// playerX goes first
				System.out.println(playerX.returnName()+" is playing");
				playerX.play(gameboard);
				System.out.println("");
				counter = 2;
				System.out.println(gameboard+"\n");
			}else
			{// playerO goes first
				System.out.println(playerO.returnName()+" is playing");
				playerO.play(gameboard);
				System.out.println("");
				counter = 1;
				System.out.println(gameboard+"\n");
			}
		}
		
		if(gameboard.returnInterState() == X)
		{
			System.out.println("X wins");
		}else if(gameboard.returnInterState() == O)
		{
			System.out.println("Y wins");
		}else
		{
			System.out.println("Draw");
		}
		
	}
}
