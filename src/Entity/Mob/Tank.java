package Entity.Mob;

import graphics.Screen;
import graphics.Sprite;

public class Tank extends Mob {
	

	private int time = 0;
	private int xx = 0, yy = 0;
	
	public Tank(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.tank;
	
	}

	 
	public void shoot(){
		   
		   if(time < 7500) time++;
		   else time = 0;
		   Player player = level.getClientPlayer();
		   if(y > player.getY() + 50) {
			   sprite = Sprite.tank_up;
			   xx = 5;
			   yy = -5;
		   }
		   else {
			   sprite = Sprite.tank;
			   xx = 10;
			   yy = 7;
		   }
		      double dx = player.getX() - x;
		      double dy = player.getY() - y;
		      double dir = Math.atan2(dy, dx);
		      if(time % (random.nextInt(5) + 10) == 0){
		    	  if(x < player.getX() + 600 && x > player.getX() + 50 && y < player.getY() + 100 && y > player.getY() - 60){
		    		  tankShoot(x + xx, y + yy,dir);
		    		  effect.tankShoot();
		    	  }
		      }
		
	}

	
    public void update() {
    	
           shoot();
    }
   
    

	public void render(Screen screen) {
		screen.renderMob(x , y , sprite, true);
		
	

	}
}


