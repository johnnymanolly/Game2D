package Level.Tile;

import graphics.Screen;
import graphics.Sprite;

public class DeadDogTile extends Tile {

	public DeadDogTile(Sprite sprite) {
		super(sprite);
		
	}


	public void render(int x, int y, Screen screen){
		screen.renderRecTile(x << 4 , y << 4,this ); // call the Screen render method, "this" replace GrassTile

	}
	
	public boolean solid(){
		return false;
	
        }
	
	public boolean is_Solid(){
		 boolean solid = false;
	return solid;
	}	
}
