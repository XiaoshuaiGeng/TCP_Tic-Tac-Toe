    

public class Tester {

	public static void main(String[] args) {
		//System.out.println("hello");
		GUI_board board = new GUI_board();
		//System.out.println(board.start);
		while(true) {
			System.out.print("");
			System.out.flush();
			if(board.start) {
				board.client.run();
				//board.unlockBoard();
			}
				
			board.start=false;
			if(board.exitFlag == true)
				break;
		}
		//board.getClient().run();
		//()
		
	}

}