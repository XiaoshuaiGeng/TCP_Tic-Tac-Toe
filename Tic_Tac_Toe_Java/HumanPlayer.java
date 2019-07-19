
import java.util.Scanner;

public class HumanPlayer extends player{
		private Scanner scan;
		/**
		 * @param name a String denotes the name of this player
		 * @param symbol a String denotes the symbol of this player, will be X and O
		 */
		protected HumanPlayer(String name, int symbol) {
			super(name, symbol);
			scan = new Scanner(System.in);
		}

		/**
		 * @param gameboard the gameboard
		 */
		protected void play(board gameboard) {
			boolean c = false;
			int a,b;
			do
			{
				System.out.println("Please enter x-axis (row)");
				a = scan.nextInt();
				System.out.println("Please enter y-axis (col)");
				b = scan.nextInt();
				
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
