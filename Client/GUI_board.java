import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class GUI_board extends JFrame{
	public Client client;
	private JButton start_Game;
	private JTextField name,IPAddress;
	private JMenu menu;
	private JMenuBar mb;
	private JMenuItem exit,restart;
	public Button[][] buttons;// a 3x3 Jbutton
	private String currentUserName;
	private String socket_IP; //store the socket IP address
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
			        		client.sendIndex(button.getIndex());
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
				socket_IP = IPAddress.getText();
				try {
					
					client = new Client(socket_IP,GUI_board.this,currentUserName);
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
					IPAddress.setEditable(false);
				}catch(ConnectException c) {
					JOptionPane.showMessageDialog(GUI_board.this,
						    "Server is not running",
						    "Connect Failed",
						    JOptionPane.WARNING_MESSAGE);
				
				}catch(UnknownHostException v){
					JOptionPane.showMessageDialog(GUI_board.this,
						    "Unknown IP address",
						    "Connect Failed",
						    JOptionPane.WARNING_MESSAGE);
				}catch(Exception e1){
					e1.printStackTrace();
				}
				//name.setEditable(false);
				
			}
			
	    });
	    	
	    name = new JTextField("Default Name");
	    //name.setBackground(Color.decode("#80FAC5"));
	    	
	    name.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentUserName = name.getText();
				start_Game.doClick();
			}
		});
	    
	    IPAddress = new JTextField("localhost");
	    IPAddress.setBackground(Color.decode("#3B5998"));
	    IPAddress.setForeground(Color.decode("#FFFFFF"));
	    IPAddress.setHorizontalAlignment(JTextField.CENTER);
	    IPAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//socket_IP = IPAddress.getText();
			}
		});
	    
	    buttonPanel.add(start_Game);
	    buttonPanel.add(name);
	    buttonPanel.add(IPAddress);
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
			    	client = new Client(IPAddress.getText(),GUI_board.this,currentUserName);
			    	start = true;
			    	
				}catch(Exception e) {
					
				}
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
	}
	public void lockBoard() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3 ;col++) {
				buttons[row][col].setEnabled(false);
			}
		}
		name.setText("Default Name");
		name.setEditable(true);
		//start_Game.setVisible(true);
		start_Game.setEnabled(true);
		IPAddress.setEditable(true);
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
		IPAddress.setEditable(false);
	}
	
	public void clearBoard() {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3 ;col++) {
				buttons[row][col].setMark("0");
			}
		}
	}

}