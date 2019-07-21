
public class AIPlayer extends player{
	
	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	
	private int[][] preferredMoves = {
			{1,1},{0,0},{0,2},{2,0},{2,2},
			{0,1},{1,0},{1,2},{2,1}
	};
	
	public AIPlayer(int symbol) {
		super("AI Player", symbol);
	}

	
	/**
	 * @param gameboard gameboard
	 * @return void will do one move
	 */
	
	
	public void play(board gameboard)
	{
		
		
		for(int [] move : preferredMoves) {
			if(gameboard.checkEmpty(move[0], move[1])) {
				gameboard.makeMove(move[0], move[1], symbol);
				break;
			}
			
			
		}
		//int a,b;
		
		/*a = (int) (Math.random() * 3);
		b = (int) (Math.random() * 3);
		
		do
		{
			if(gameboard.checkEmpty(a, b))
			{
				gameboard.makeMove(a, b, symbol);
				//System.out.println("AI Player Moved.");
				break;
			}
		}while(!gameboard.checkEmpty(a, b));*/
	}
	
}

