package Level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class GrassSpot extends Tile {

	public GrassSpot(Sprite sprite) {
		super(sprite);
		
	}


	public void render(int x, int y, Screen screen){
		screen.renderRecTile(x << 4 , y << 4,this ); // call the Screen render method, "this" replace GrassTile

	}
	
	public boolean solid(){
		return true;
	
        }
	
	public boolean is_Solid(){
		 boolean solid = true;
	return solid;
	}	
}
