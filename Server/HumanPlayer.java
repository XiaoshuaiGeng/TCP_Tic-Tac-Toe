
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HumanPlayer extends player{
		
		//private PrintWriter output;
		//private Scanner input;
	
		/**
		 * @param name a String denotes the name of this player
		 * @param symbol a String denotes the symbol of this player, will be X and O
		 */
		public HumanPlayer(String name, int symbol) {
			super(name, symbol);
			//this.input = input;
			//this.output = output;
		}

		/**
		 * @param gameboard the gameboard
		 */
		public void play(int[] index,board gameboard) throws IllegalStateException {
			
			gameboard.makeMove(index[0],index[1], returnsym());
			
		}
		
}
