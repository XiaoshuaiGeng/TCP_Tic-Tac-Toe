import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import Client.GUI_board.block;

@SuppressWarnings("serial")
public class GUI_board extends JFrame{
	public Client client;
	private JButton start_Game;
	private JTextField name;
	private JMenu menu;
	private JMenuBar mb;
	private JMenuItem exit,restart;
	public Button[][] buttons;// a 3x3 Jbutton
	private String currentUserName;
	//private JFrame fr;
	//private String symbol = "O";
	//public PrintWriter output;
	public boolean start = false;
	public boolean exitFlag = false;
		
	public GUI_board()
	{
		super("Tic-Tac-Toe");
		JPanel buttonPanel = new JPanel(new GridLayout(4,3));
	    buttons = new Button[3][3];
	    int row,col;
	    
	    
	    for(row = 0; row < 3; row++)
	    {
	    	for(col = 0; col < 3; col++)
	        {
	        	buttons[row][col] = new Button("INDEX [" + row + "," + col+ "]");
	        	buttons[row][col].addActionListener(new ActionListener()
	        	{
			        	public void actionPerformed(ActionEvent e)  
			        	{  	
			        		Button button = (Button) e.getSource();
			        		//buttons[row][col].setMark(client.getSymbol());
			        		//String a = buttons[row][col].getIndex();
			        		client.sendIndex(button.getIndex());
			        		//buttons[row][col].setEnabled(false);
			        	}
	        	});
	        	buttonPanel.add(buttons[row][col]);	
	        }
	    }
	    
	    start_Game = new JButton("Start");
	    start_Game.setBackground(Color.decode("#3B5998"));
	    start_Game.setForeground(Color.decode("#FFFFFF"));
	    //buttonPanel.add(start_Game);
	    //start_Game.setBounds(125,270,150,50);
	    start_Game.addActionListener(new ActionListener() 
	    {
			
			public void actionPerformed(ActionEvent e) {
				
				currentUserName = name.getText();
				
				try {
					
					client = new Client(GUI_board.this,currentUserName);
					//getClient().run();
					start = true;
					JButton button = (JButton) e.getSource();	//get the current button
					button.setEnabled(false);	//disable current button
					for(int row = 0; row < 3; row++) {
						for(int col = 0; col < 3 ;col++) {
							
							buttons[row][col].setEnabled(true);
							
						}
					}
					name.setEditable(false);
				}catch(Exception e1){
					e1.printStackTrace();
				}
				//name.setEditable(false);
				
			}
			
	    });
	    
	     /*start_Game.addActionListener(new ActionListener() 
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
	     });*/
	    	
	    name = new JTextField("Default user");
	    //name.setBackground(Color.decode("#80FAC5"));
	    	
	    name.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentUserName = name.getText();
				start_Game.doClick();
			}
		});
	    
	    
	    buttonPanel.add(start_Game);
	    buttonPanel.add(name);
	        
	        // set menu
		mb = new JMenuBar();
		menu = new JMenu("Menu");
		exit = new JMenuItem("Exit");
		restart = new JMenuItem("Restart");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
		    {
				if(client == null) {
					dispose();
					exitFlag = true;
					
				}
				else {
					try {
					client.quit();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    	exitFlag = true;
		    	dispose();
				}
		    	
		    	
		    		
		    }	
		    	
		});
		
		restart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
		    {
				
				try {
					client.quit();
					clearBoard();
					unlockBoard();
			    	client = new Client(GUI_board.this,currentUserName);
			    	start = true;
			    	
				}catch(Exception e) {
					
				}
		    	
//		   		dispose();
		   	}
		});
		   
		menu.add(exit);
		menu.add(restart);
		mb.add(menu);
		    
		this.setJMenuBar(mb);
	    this.add(buttonPanel);
	        
	    this.setSize(400,450);
		this.setVisible(true);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//lockBoard();
	}
	public void lockBoard() {
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3 ;col++) {
				
				buttons[row][col].setEnabled(false);
				
			}
		}
		name.setText("Please enter your name");
		name.setEditable(true);
		//start_Game.setVisible(true);
		start_Game.setEnabled(true);
	}
	public void unlockBoard() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3 ;col++) {
				
				buttons[row][col].setEnabled(true);
				
			}
		}
		name.setEditable(false);
		//start_Game.setVisible(false);
		start_Game.setEnabled(false);
	}
	
	public void clearBoard() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3 ;col++) {
				
				buttons[row][col].setMark("0");
				
			}
		}
	}

}