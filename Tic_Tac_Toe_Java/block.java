
public class block implements global{
	private int state;
	
	
	/**
	 * @return create a block with state is E
	 */
	protected block()
	{
		this.state = E;
	}
	
	
	/**
	 * @return the state of this block
	 */
	protected int getState()
	{
		return state;
	}
	
	/**
	 * @return set state to given String
	 */
	protected void setState(int a)
	{
		state = a;
	}
	
	/**
	 * @return its state
	 */
	public String toString()
	{
		if(state == E)
		{
			return String.format("%10s", " ");
		}if(state == X)
		{
			return String.format("%10s", "X");
		}else
		{
			return String.format("%10s", "O");
		}
		
	}
}
