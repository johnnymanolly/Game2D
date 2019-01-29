package Entity.Mob;

import graphics.Animatedsprite;
import graphics.Screen;
import graphics.SpriteSheet;

public class SmallTankDestroyed extends Mob {

	
	private Animatedsprite roll = new Animatedsprite(SpriteSheet.small_tank_destroyed, 73, 66, 5);
	
	private Animatedsprite animSprite = roll;
	
	private int time = 0;
	public int xa = 0;
	public int ya = 0;
	public int xx = 0;
	public int yy = 0;
	
	public SmallTankDestroyed(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = animSprite.getSprite();
		
	
	}
	

    public void update() {

	    

        	animSprite.updateOnce();

     
        //	animSprite.setFrame(3);
 
	     
    }


	public void render(Screen screen) {
	    sprite = animSprite.getSprite();
		screen.renderMob(x , y , sprite, true);
		
	

	}
}


