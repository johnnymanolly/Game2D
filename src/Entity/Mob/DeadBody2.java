package Entity.Mob;

import Entity.Mob.Mob.Direction;
import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class DeadBody2 extends Mob{
	
	
	private int timer = 0;
	
	public DeadBody2(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		
		sprite = Sprite.dead_body2 ;
	
	}
	
	
	
    public void update() {
    	
     
	}
   
    

	public void render(Screen screen) {
		screen.renderMob(x , y + 20, sprite, true);
		
	

	}
}



