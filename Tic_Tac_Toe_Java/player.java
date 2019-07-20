
public abstract class player{

	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	private String name;
	private int symbol;
	
	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	protected player(String name, int symbol)
	{
		if(name.equals("Enter name for player 1") || name.equals("Enter name for player 2"))
		{
			this.name = "default player";
		}else
		{
			this.name = name;
		}
		this.symbol = symbol;
	}
	
	/**
	 * @return the symbol of this player
	 */
	protected int returnsym()
	{
		return symbol;
	}
	
	/**
	 * @return the name of this player
	 */
	protected String returnName()
	{
		return name;
	}
	
	/**
	 * @param gameboard a board
	 */
	protected abstract void play(board gameboard);
}
