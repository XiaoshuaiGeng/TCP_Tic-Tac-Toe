
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HumanPlayer extends player{
		
		private PrintWriter output;
		private Scanner input;
	
		/**
		 * @param name a String denotes the name of this player
		 * @param symbol a String denotes the symbol of this player, will be X and O
		 */
		public HumanPlayer(String name, int symbol,Scanner input,PrintWriter output) {
			super(name, symbol);
			this.input = input;
			this.output = output;
		}

		/**
		 * @param gameboard the gameboard
		 */
		public void play(int[] index,board gameboard) throws IllegalStateException {
			//boolean c;
			//int row = -1,col = -1;//store the player's next move
			
			/*do {
				try {
					String getInput;
					output.println("REQUEST Please enter row and col num:   e.g [row,col] ");
					getInput = input.nextLine();
					row = Integer.parseInt(getInput.substring(1, 2));
					col = Integer.parseInt(getInput.substring(3,4));
							
					if(gameboard.checkEmpty(row, col)) {
						break;
					}
				}catch(Exception e) {
						output.println("That may be an invalid input");
				}
				
			}while(true);*/
			
			gameboard.makeMove(index[0],index[1], returnsym());
			
		}
		
}
