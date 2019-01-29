package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launcher extends JFrame {
	private static final long serialVersionUID = 1L;
	

	private JButton play, options, score, quit;
	private Rectangle rplay, roptions, rscore, rquit;
	
	private int width = 320;
	private int height = 400;
	private int button_width = 120;
	private int button_height = 40;
	   
	public Launcher(){
		
		Rambo rambo = new Rambo();
	
		drawButtons();
		
		add(rambo);
		
	
		setTitle("Menu");
		setResizable(false);		
		setSize(new Dimension(width,height));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	
	public void drawButtons(){
		play = new JButton("Play!");
		rplay = new Rectangle((width/2) - (button_width/2), 140, button_width,button_height);
		play.setBounds(rplay);
		add(play);
		
		play.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			new RunGame();
				
			}
		});
		
		
		options = new JButton("Options");
		roptions = new Rectangle((width/2) - (button_width/2), 190, button_width,button_height);
		options.setBounds(roptions);
		add(options);
		
		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Options();
					
				}
			});
			
		
		
		score = new JButton("Score");
		rscore = new Rectangle((width/2) - (button_width/2), 240, button_width,button_height);
		score.setBounds(rscore);
		add(score);
		
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Score();
				dispose();
				}
			});
		
		quit = new JButton("Quit");
		rquit = new Rectangle((width/2) - (button_width/2), 290, button_width,button_height);
		quit.setBounds(rquit);
		add(quit);
		
	
		
		quit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}
	
	 public class Rambo extends JPanel{
			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private Image img;
		//    private BufferedImage img;
			
			public Rambo(){
				img = new ImageIcon("Rambo.png").getImage();
				
//				  try {
//		                img = ImageIO.read(new File("Rambo.png"));
//		            } catch (IOException ex) {
//		                ex.printStackTrace();
//		            }
			}
			
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.black);
				g.fillRect(0, 0, width, height);
				g.drawImage(img, (width / 2) - (img.getWidth(null) / 2) - 10, 10, 90, 90, null);
				
			}
		}

}
