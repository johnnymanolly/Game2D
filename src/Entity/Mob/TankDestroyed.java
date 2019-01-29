package Entity.Mob;

import graphics.Animatedsprite;
import graphics.Screen;
import graphics.SpriteSheet;

public class TankDestroyed extends Mob {

	
	private Animatedsprite roll = new Animatedsprite(SpriteSheet.tank_destroyed_anim, 202, 89, 4);
	
	private Animatedsprite animSprite = roll;
	
	private int time = 0;
	public int xa = 0;
	public int ya = 0;
	public int xx = 0;
	public int yy = 0;
	
	public TankDestroyed(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = animSprite.getSprite();
		
	
	}
	

    public void update() {

        	animSprite.update();

    }


	public void render(Screen screen) {
	    sprite = animSprite.getSprite();
		screen.renderMob(x , y , sprite, true);
		
	

	}
}


