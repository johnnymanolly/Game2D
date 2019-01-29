package Menu;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Scanner;

import Entity.Entity;
import MyGame.Game;

public class Score extends JFrame{
	
    Entity entity;
    BufferedReader br;
    Game game;
	private static final long serialVersionUID = 1L;
	
	JLabel top_score;
	
	private int width = 240;
	private int height = 320;
	private int button_width = 80;
	private int button_height = 40;
	private static String TOP_SCORE;
	
	private JButton back;
	private Rectangle rback;
	
	private JPanel window = new JPanel();
	File myfile = new File("myscore.txt");
	
	public Score(){
		
		entity = new Entity();
		game = new Game();
		getContentPane().add(window);
		window.setLayout(null);
		
		setTitle("Score");
		setResizable(false);		
		setSize(new Dimension(width,height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		drawButtons();
		displayTopScore();
	
	}
	
	public void displayTopScore() {
		try {
			Scanner in = new Scanner(myfile);
			TOP_SCORE = in.next();
			top_score = new JLabel();
			top_score.setBounds((width/2) - (button_width/2), 50, button_width + 50,button_height + 50);
			top_score.setText("TOP_SCORE: " +TOP_SCORE);
			window.add(top_score);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
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
		
		
	}
	
	

}
