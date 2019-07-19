
public class board implements global {
	private block[][] blo = new block[3][3];
	private int interState;
	
	protected board()
	{
		for(int i = 0; i<3;i++)
		{
			for(int a = 0;a<3;a++)
			{
				blo[i][a] = new block();
			}
		}
		this.interState = E;
	}
	
	/**
	 * @return its interstate
	 */
	protected int returnInterState()
	{
		return interState;
	}
	
	/**
	 * @return this block
	 */
	public String toString()
	{
		return "\t" +String.format("%10s", "col 0") + String.format("%10s", "col 1") + String.format("%10s", "col 2")+"\nrow 0" + blo[0][0].toString() + blo[0][1].toString()+blo[0][2].toString()+"\nrow 1"+blo[1][0].toString() + blo[1][1].toString()+blo[1][2].toString()+"\nrow 2"+blo[2][0].toString() + blo[2][1].toString()+blo[2][2].toString();
	}
	
	/**
	 * @param a an integer denotes x-axis
	 * @param b an integer denotes y-axis
	 * @param sym a String denotes player's symbol
	 */
	protected void makeMove(int a, int b, int sym)
	{
		blo[a][b].setState(sym);
		updateState();
	}
	
	/**
	 * @param a an positive integer denotes x-axis
	 * @param b an positive integer denotes y-axis
	 * @return whether position [a][b] is empty or not
	 */
	protected boolean checkEmpty(int a, int b)
	{
		if(blo[a][b].getState() == E)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return check if this game ends
	 */
	protected void updateState()
	{
		int i;
	

		//check row
		for(i = 0; i < 3; i++)
		{
			if (checkCol(blo[i][0].getState(), blo[i][1].getState(), blo[i][2].getState()) == true)
			{
				interState = blo[i][0].getState();
				return;
			}
		}
		//check col
		for(i = 0; i < 3; i++)
		{
			if (checkCol(blo[0][i].getState(), blo[1][i].getState(), blo[2][i].getState()) == true)
			{
				interState = blo[0][i].getState();
				return;
			}
		}
		//check dia
		if (checkCol(blo[0][0].getState(), blo[1][1].getState(), blo[2][2].getState()) == true || checkCol(blo[0][2].getState(), blo[1][1].getState(), blo[2][0].getState()) == true)
		{
			interState = blo[1][1].getState();
			return;
		}
		
		//check ful
		for(i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(blo[i][j].getState() == E)
				{
					interState = E;
					return;
				}
			}
		}

		interState = draw;
		
	}

	/**
	 * @param s1 first String
	 * @param s2 second String
	 * @param s3 third String
	 * @return true if given three String are equal && not empty
	 */
	private boolean checkCol(int s1, int s2, int s3)
	{
		return(s1 != E && s1 == s2 && s2 == s3);
	}
	
}
