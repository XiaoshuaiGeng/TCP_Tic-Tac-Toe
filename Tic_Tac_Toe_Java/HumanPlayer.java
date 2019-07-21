
import java.util.Scanner;

public class HumanPlayer extends player{

	
		/**
		 * @param name a String denotes the name of this player
		 * @param symbol a String denotes the symbol of this player, will be X and O
		 */
		protected HumanPlayer(String name, int symbol) {
			super(name, symbol);
		}

		/**
		 * @param gameboard the gameboard
		 */
		public void play(int row,int col,board gameboard) {
			boolean c;
			int a,b;
			
			while(gameboard.checkEmpty(row, col))s
			
			do
			{
				
				c = gameboard.checkEmpty(a, b);
				
				if(c)
				{
					gameboard.makeMove(a, b, super.returnsym());
					System.out.println("");
				}else
				{
					System.out.println("Location not empty or invaild input.");
				}
				
			}while(!c);
		}
}
