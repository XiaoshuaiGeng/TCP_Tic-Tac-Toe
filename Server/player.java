
public abstract class player{

	/**
	 * @param name a String denotes the name of this player
	 * @param symbol a String denotes the symbol of this player, will be X and O
	 */
	protected String name;
	protected int symbol;

	public player(String name, int symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	public int returnsym()
	{
		return symbol;
	}

	public String returnName()
	{
		return name;
	}
	
	/**
	 * @param gameboard a board
	 */
	public abstract void play(int[] index,board gameboard) throws IllegalStateException;
}
