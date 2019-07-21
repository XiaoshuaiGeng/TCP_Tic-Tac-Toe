
public class block {
	private int state = 0;
	
	/**
	 * @return create a block with state is E
	 */
	public block()
	{
		this.state = global.E;
	}
	
	
	/**
	 * @return the state of this block
	 */
	public int getState()
	{
		return state;
	}
	
	/**
	 * @return set state to given String
	 */
	public void setState(int state)
	{
		this.state = state;
	}
	
	/**
	 * @return its state
	 */
	public String toString()
	{
		if(state == global.E)
		{
			return String.format("%10s", " ");
		}else if(state == global.X)
		{
			return String.format("%10s", "X");
		}else
		{
			return String.format("%10s", "O");
		}
		
	}
}
