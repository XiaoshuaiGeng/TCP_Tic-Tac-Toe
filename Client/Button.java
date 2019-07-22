import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton{
	
	private String index;
	
	
	//When creating the button, pass an index like [1,0]
	//The button will store that index
	//Will initialize a Jbutton with void text
	public Button(String index) {
		super();
		this.index = index;
		
	}
	
	
	public String getIndex() {
		return index;
	}
	
	public void setMark(String mark) {
		if(mark.equals("0"))
			setText("");
		if(mark.equals("1")) {
			setText("X");
			this.setEnabled(false);
		}
		if(mark.equals("2")) {
			setText("O");
			this.setEnabled(false);
		}
	}
	public Button getButton() {
		return this;
	}
	
}
