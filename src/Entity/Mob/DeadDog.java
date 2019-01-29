package Entity.Mob;

import Entity.Mob.Mob.Direction;
import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class DeadDog extends Mob{
	
	
	
	
	public DeadDog(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.dead_dog;
	
	}
	
	
	
    public void update() {
    	
     
	}
   
    

	public void render(Screen screen) {
		screen.renderMob(x , y , sprite, true);
		
	

	}
}



