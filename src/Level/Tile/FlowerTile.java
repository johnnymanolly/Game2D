package Level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	
		// set x and y to set the position of the tile on the screen
		public void render(int x, int y, Screen screen){
			screen.renderTile(x << 4, y << 4, this); // call the Screen render method, "this" replace GrassTile
		}
		
		public boolean solid(){
			return false;
		
		
	}

}
