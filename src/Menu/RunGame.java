package Menu;

import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import MyGame.Game;
import MyGame.StopWatch;


public class RunGame {
 
	public RunGame() { 
	
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Shooter");
		game.frame.add(game);
		game.frame.pack(); // set the size
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate
																	// the
																	// program
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.frame.setCursor(game.frame.getToolkit().createCustomCursor(
	            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
	            "null"));

		game.start();
		new StopWatch();
	
	}


}
