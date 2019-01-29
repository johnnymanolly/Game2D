package Level.Tile;


import graphics.Screen;
import graphics.Sprite;

public class TreeTile extends Tile {

	public TreeTile(Sprite sprite) {
		super(sprite);

	}
	
	 public void render(int x, int y, Screen screen){
		   screen.renderTile(x << 4 , y << 4 , this);
	   }

}
