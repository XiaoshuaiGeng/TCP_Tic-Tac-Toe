package TicTacToeClient;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import TicTacToe.TicTacToeClient;
import TicTacToe.TicTacToeClient.Square;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import java.io.PrintWriter;
import java.net.Socket;


public class TicTacToeClients extends JFrame{
		JLayeredPane layeredpane ;
		JPanel panel;
		JLabel label;
		ImageIcon background;
		JButton begin;
		
		
		private Square[] board = new Square[9];
		private Square currentSquare;
	
		public static void main(String [] args)
		{
			TicTacToeClients client = new TicTacToeClients();
		}
	
		public TicTacToeClients()
		{
			layeredpane = new JLayeredPane();
			background = new ImageIcon("C:\\\\Users\\\\brist\\\\Desktop\\\\wireshark\\\\Project.jpg");
			//create a LayeredPane
		
			panel = new JPanel();
			panel.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
			label = new JLabel(background);
			panel.add(label);
			begin = new JButton("Begin");
			begin.setBounds(200,450,200,50);
			//find a picture and then add the picture to the label
			//add the label to the panel
			//add a button
		
			layeredpane.add(panel,JLayeredPane.DEFAULT_LAYER);//put the panel to the bottom layer
			layeredpane.add(begin,JLayeredPane.MODAL_LAYER);//put the button to a higher layer
		
			this.setLayeredPane(layeredpane);
			this.setSize(background.getIconWidth(),background.getIconHeight());//set the frame size
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocation(background.getIconWidth(),background.getIconHeight());
			this.setVisible(true);	
			
			thehandler handler = new thehandler();
			begin.addActionListener(handler);
			//add listener to pop up another frame

		}
		private class thehandler implements ActionListener{
			public void actionPerformed(ActionEvent event)
			{
				gameboard();
					
			}

			
		}
		
		private void gameboard()
		{

			JFrame playwindow = new JFrame("Hey");
			playwindow.setVisible(true);
			playwindow.setSize(600,600);
			//after we click the begin button, another frame appears
			
			
			
			JPanel Panel = new JPanel();
		    Panel.setBackground(Color.blue);
		    //a new panel for adding squares
		    Panel.setLayout(new GridLayout(3, 3, 2, 2));
		    //divide the panel into 9 pieces
		    board[1] = new Square();
		    Panel.add(board[1]);
		    /**
		     * for (int i = 0; i < board.length; i++) {
		    
		            final int j = i;
		            board[i] = new Square();
		            Panel.add(board[i]);
		        }
	     */
		    playwindow.getContentPane().add(Panel, BorderLayout.CENTER);
		}
		
		static class Square extends JPanel 
		{
		        JLabel label = new JLabel();

		        public Square() {
		            setBackground(Color.white);
		            setLayout(new GridBagLayout());
		            label.setFont(new Font("Arial", Font.ITALIC, 42));
		            add(label);
		        }

		        public void setText(char text) {
		            label.setForeground(text == 'X' ? Color.BLUE : Color.RED);
		            label.setText(text + "");
		        }
		 }
		
		
		
			
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	    
	

	
	 
			
			 
			
		 


		
		 
		
	
	
	
	
	



/**
 * public void setLayered()
	    { 
			 ((JPanel)this.getContentPane()).setOpaque(false); 
			 ImageIcon img = new ImageIcon("C:\\Users\\brist\\Desktop\\wireshark\\Project.jpg"); 
			 //to get the picture
			 JLabel background = new JLabel(img);
			 //set picture to be a label
			 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
			 //add the picture(JLable) to the layeredPane
			 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			 //set bounds
		}
	    
	    public void setContent()
	    {
	    	 
	    	 content=(JPanel)getContentPane();  
	    	 content.setOpaque(false);
	    	 JButton button = new JButton("Begin");
	    	 content.add(button);
	    	
	    	
	    	
	    }
	   **/
