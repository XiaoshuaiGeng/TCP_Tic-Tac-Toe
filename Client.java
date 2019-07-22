import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * A command line client for the date server. Requires the IP address of
 * the server as the sole argument. Exits after printing the response.
 */
public class Client {
	public static Socket socket;
	public static boolean flag;
	
	public static class GUI_board extends JFrame{
		private block[][] blo;
		//private String interState;
		private JFrame fr;
		private String symbol = "O";
		public PrintWriter output;
		
		/**
		 * @return create new board
		 */

		public JButton start_Game,sym;
		public JTextField name, records;
		private JMenu menu;
		private JMenuBar mb;
		private JMenuItem exit,restart;
		protected GUI_board(PrintWriter output)
		{
			
			this.output = output;
			fr = new JFrame("Tic-Tac-Toe board");
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new GridLayout(4,3));
	        blo = new block[3][3];
	        
	        for(int a = 0; a < 3; a++)
	        {
	        	for(int b = 0; b < 3; b++)
	        	{
	        		blo[a][b] = new block("INDEX [" + a + "," + b+ "]");
	        		blo[a][b].returnBut().addActionListener(new ActionListener()
	        				{
			        			public void actionPerformed(ActionEvent e)  
			        			{  	
			        				JButton butt = (JButton) e.getSource();
//			        				butt.setText(Symbol);
			        				output.println(butt.getName());
			        				
			        	    	}
	        				});

	        		buttonPanel.add(blo[a][b].returnBut());
	        	}
	        }
	        start_Game = new JButton();
	    	start_Game.setText("Start The Game");
	    	start_Game.setBackground(Color.decode("#80FAC5"));
	    	start_Game.setForeground(Color.decode("#F35050"));
	    	start_Game.setBounds(125,270,150,50);
	    	start_Game.addActionListener(new ActionListener() 
	    	{
	    		public void actionPerformed(ActionEvent e) 
	    		{
	    			output.println(name.getText());
	    			for(int i=0;i<3;i++) {
	    				for(int j=0;j<3;j++) {
	    					blo[i][j].returnBut().setEnabled(true);
	    				}
	    			}
	    			name.setEditable(false);
	    			name.setHorizontalAlignment(JTextField.CENTER);
	    			name.setForeground(Color.BLACK);
	    		}
	    	});
	    	
	    	name = new JTextField("enter your name");
	    	name.setBackground(Color.decode("#80FAC5"));
	    	
	    	sym = new JButton("Your Symbol: X");
	    	sym.setBackground(Color.decode("#80FAC5"));
	    	sym.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)  
				{  	
					JButton a = (JButton) e.getSource();
					if(a.getText().equals("Your Symbol: X"))
						a.setText("Your Symbol: O");
					else
						a.setText("Your Symbol: X");
		    	}
			});
	        buttonPanel.add(start_Game);
	        buttonPanel.add(name);
	        buttonPanel.add(sym);
	        
	        
	        // set menu
		    mb = new JMenuBar();
		    menu = new JMenu("Menu");
		    exit = new JMenuItem("Exit");
		    restart = new JMenuItem("Restart");
		    exit.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent ev)
		    	{
		    		flag = false;
		    		output.println("QUIT");
		    		//System.out.println(flag);
		    		fr.dispose();
		    		
		    	}	
		    	
		    });
		    restart.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent ev)
		    	{
		    		output.println("RESTART");
		    		for(int i=0;i<3;i++) {
		    			for(int j=0;j<3;j++) {
		    				blo[i][j].returnBut().setEnabled(true);
		    				blo[i][j].setState(0);;
		    			}

		    		}
		    		name.setEditable(true);
//		    		dispose();
		    	}
		    });
		   
		    menu.add(exit);
		    menu.add(restart);
		    mb.add(menu);
		    
		    fr.setJMenuBar(mb);
	        fr.add(buttonPanel);
	        
	        fr.setSize(400,450);
		    fr.setVisible(true);  
		}
		
		

		protected void gameEnd()
		{
			fr.setVisible(false);
		}
		
		
		//block start from here
		public class block {

			public JButton myButton;
			public int state;
			
			/**
			 * @return declare a new button with state empty
			 */
			protected block(String title)
			{
				this.myButton = new JButton("");
				myButton.setName(title);
				this.state = 0;
			    this.myButton.setSize(50,50);;
			}
			
			
			/**
			 * @param newState a string denotes the new state, assuming it is always X or O
			 * @return void method will change the state
			 */
			protected void setState(String newState)
			{
				myButton.setText(newState);
				if(newState == "X")
					this.state = 1;
				else
					this.state = 2;
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
				if(state==1) {
					this.myButton.setText("X");
				}
				if(state==2) {
					this.myButton.setText("O");
				}
				if(state==0) {
					this.myButton.setText("");
				}
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
			/**
			 * @return the button this block
			 */
			public JButton returnBut()
			{
				return this.myButton;
			}

		}



	}
	
    public static void main(String[] args) throws IOException {
//        if (args.length != 1) {
//            System.err.println("Pass the server IP as the sole command line argument");
//            return;
//        }
    	flag = true;
        socket = new Socket("10.204.56.248", 59090);
        //10.242.62.138 127.0.0.1
        Scanner input = new Scanner(socket.getInputStream());
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        //Scanner in = new Scanner(System.in);
        
        output.println("A new opponent joined...");
        
        GUI_board GUI_b = new GUI_board(output);//create a gui board
        
        //disable all button at first
        for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				GUI_b.blo[i][j].returnBut().setEnabled(false);
			}
		}
        
        try {
        	while(flag == true && input.hasNextLine()) {
        		//System.out.println(flag);
//        		if(flag==false)
//        			break;
        		String command = input.nextLine();
        		System.out.println(command);
        		//getting board info
        		if(command.startsWith("BOARD")) {
        			for(int i=6; i<command.length();i++) {
        				// index start from 6 after "BOARD "
        				if(i>=6 && i <9) {
        					GUI_b.blo[0][i-6].setState(Integer.parseInt(command.substring(i,i+1)));
        				}
        				if(i>=9 && i<12) {
        					GUI_b.blo[1][i-9].setState(Integer.parseInt(command.substring(i,i+1)));
        				}
        				if(i>=12) {
        					GUI_b.blo[2][i-12].setState(Integer.parseInt(command.substring(i,i+1)));
        				}
        			}
        			//disable selected button
        			for(int i=0;i<3;i++) {
        				for(int j=0;j<3;j++) {
        					if(GUI_b.blo[i][j].getState()!=0)
        						GUI_b.blo[i][j].returnBut().setEnabled(false);
        					
        				}
        			}
        		}
        		//if game finished
        		if(command.startsWith("GAME")) {
        			for(int i=0;i<3;i++) {
        				for(int j=0;j<3;j++) {
        					GUI_b.blo[i][j].returnBut().setEnabled(false);
        					break;
        					
        				}
        			}
        		}
        		//enter player's name (need to be modified with textfield)        		
        		if(command.startsWith("NAME")) {
        			for(int i=0;i<3;i++) {
        				for(int j=0;j<3;j++) {
        					GUI_b.blo[i][j].returnBut().setEnabled(false);
        				}
        			}
        			GUI_b.name.setEditable(true);
        		}
        		//request players move
        		//going to be delete after test
//        		if(command.startsWith("REQUEST MOVE")) {
//        			for(int i=0;i<3;i++) {
//        				for(int j=0;j<3;j++) {
//        					if(GUI_b.blo[i][j].getState()!=0)
//        						GUI_b.blo[i][j].returnBut().setEnabled(false);
//        					
//        				}
//        			}
//        		}
        		
        	}
        	
        	System.out.println("quit");
        	input.close();
        	output.close();
        	socket.close();
        	GUI_b.fr.setVisible(false);
        	GUI_b.dispose();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
    
}
