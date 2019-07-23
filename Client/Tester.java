import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws Exception {
		
		
		GUI_board board = new GUI_board();
		Client client = new Client(board);
		board.client = client;
		board.lockBoard();
		while(!client.gameStart) {
			System.out.print("");
			System.out.flush();
		}
		
		System.out.println("game Start\n");
			try {
				
				client.run();
			
			} catch (Exception e) {
				System.out.println("error");
		}
		//Client.start(GUI_board)
		//()
		
	}

}
