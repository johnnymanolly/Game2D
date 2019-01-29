package Level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class GrassTile extends Tile{

	public GrassTile(Sprite sprite) {
		super(sprite); // set sprite to the grass tile
	
	} 
	
	// set x and y to set the position of the tile on the screen
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4 , this); // call the Screen render method, "this" replace GrassTile
                // if x=0, xp = 0, x=1, xp= 16
	}
	
	public boolean solid(){
		return false;
	}
	

}
