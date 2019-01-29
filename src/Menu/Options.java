package Menu;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.Entity;
import MyGame.Game;

public class Options extends JFrame {
	
  
	private int width = 240;
	private int height = 320;
	private int button_width = 80;
	private int button_height = 40;
	private JButton back;
	private Rectangle rback;
	Game game;
	JComboBox<String> combo;
	private  String[] users = {"1","2","3"};
	
	JLabel scale;
	
	private JPanel window = new JPanel();
	
     public Options(){
        
		
	
		getContentPane().add(window);
		window.setLayout(null);
		
		setTitle("Score");
		setResizable(false);		
		setSize(new Dimension(width,height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		drawButtons();
		resolution();
	
	}
     
     public void resolution(){
    	 combo =  new JComboBox(users);
    	 combo.setBounds((width/2) - (button_width/2), 50, button_width + 20 ,button_height - 20 );
    	 window.add(combo); 
     }
     
     public void getresolution(){
    	 if(combo.getSelectedItem()== "1") game.scale = 1;
    	 if(combo.getSelectedItem()== "2") game.scale = 2;
    	 if(combo.getSelectedItem()== "3") game.scale = 3;
     }
     

public void drawButtons(){
	
	back = new JButton("back");
	rback = new Rectangle((width/2) - (button_width/2), 200, button_width,button_height);
	back.setBounds(rback);
	window.add(back);
	
	back.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		dispose();
		new Launcher();
			
		}
	});
	
	scale = new JLabel();
	scale.setBounds((width/2) - (button_width/2), 30, button_width + 20 ,button_height - 20);
	scale.setText("Resolution");
	window.add(scale);
} 


}
