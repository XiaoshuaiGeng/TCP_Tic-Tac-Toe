
public abstract class player{

	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	protected String name;
	protected int symbol;
	
	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	public player(String name, int symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	/**
	 * @return the symbol of this player
	 */
	public int returnsym()
	{
		return symbol;
	}
	
	/**
	 * @return the name of this player
	 */
	public String returnName()
	{
		return name;
	}
	
	/**
	 * @param gameboard a board
	 */
	public abstract void play(board gameboard);
}
