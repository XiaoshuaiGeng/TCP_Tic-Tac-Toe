
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
	
	
	//int[] index require a array contains 2 element indicating its row and col
	//a gameboard which contains the game status, check if the block is empty
	public void play(int[] index,board gameboard) throws IllegalStateException
	{	
		gameboard.makeMove(index[0], index[1], symbol);	
	}
	
	//AI will traverse every block and return a valid index for it to move
	public int[] move(board gameboard) {
		for(int [] move : preferredMoves) {
			if(gameboard.checkEmpty(move[0], move[1])) {
				return new int[] {move[0],move[1]};
			}
		}
		return new int[] {-1,-1};
	}
	
}

