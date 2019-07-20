
public class AIPlayer extends player{
	
	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	protected AIPlayer(int symbol) {
		super("Default AI Player", symbol);
	}

	
	/**
	 * @param gameboard gameboard
	 * @return void will do one move
	 */
	protected void play(board gameboard)
	{
		int a,b;
		
		//a = (int) (Math.random() * 3);
		//b = (int) (Math.random() * 3);
		
		do
		{
			a = (int) (Math.random() * 3);
			b = (int) (Math.random() * 3);
			if(gameboard.checkEmpty(a, b))
			{
				gameboard.makeMove(a, b, returnsym());
				System.out.println("AI Player Moved.");
				break;
			}
		}while(!gameboard.checkEmpty(a, b));
	}
	
}

