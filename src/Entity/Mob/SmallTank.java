package Entity.Mob;

import Entity.Mob.Mob.Direction;
import MyGame.Game;
import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class SmallTank extends Mob {

	
	private Animatedsprite roll = new Animatedsprite(SpriteSheet.tank_rotation, 4 * 16, 4 * 16, 9);
	
	private Animatedsprite animSprite = roll;
	
	private int time = 0;
	public int xa = 0;
	public int ya = 0;
	public int xx = 0;
	public int yy = 0;
	
	public SmallTank(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = animSprite.getSprite();
	
	}
	
	private void move() {
	
       
	    if((xa != 0 || ya != 0)) {
	    	  
	      move(xa, ya);          
	      walking = true;}
	      
	      else{
	    	  walking = false;
	    	  }
	    
	    //  System.out.println("Chaser X: " + (x << 4));
	}
	
	public void shoot(){
		   
		   if(time < 7500) time++;
		   else time = 0;
		   Player player = level.getClientPlayer();
		   if(y > player.getY() + 50) {
			yy = 5;
		   }
		   else {
			yy = 5;
		   }
		      double dx = player.getX() - x;
		      double dy = player.getY() - y;
		      double dir = Math.atan2(dy, dx);
		      if(time % (random.nextInt(5) + 50) == 0){
		    	  if(x < player.getX() + 400 && x > player.getX() - 400 && y < player.getY() + 300 && y > player.getY() - 300){
		    		  smallTankShoot(x + xx, y + yy,dir);
		    		  effect.tankShoot();
		    		  animSprite.setFrame(0);
		    	  }
		      }
		
	}
	
	public void moveRandomly(){
		
		if(time < 7500) time++;
		else time = 0;

        if(time % (random.nextInt(50) + 30) == 0){
        	xa = random.nextInt(3) - 1;
        	ya = random.nextInt(3) - 1;
        	if(random.nextInt(4) == 0){
        		xa = 0;
        		ya = 0;
        	}
        } 
	}


    public void update() {
    	
        
    	
    	Player player = level.getClientPlayer();
    	moveRandomly();
	    move();
	    shoot();
   
      if(walking){ animSprite.update();
      } else{
    	  animSprite.setFrame(0);
      
      }
     
  	  if(ya < 0) {
			
		//	  animSprite = right;
			  dir = Direction.UP;
			  
		  }else if(ya > 0){
			  
	    //	  animSprite = right;
	    	  dir = Direction.DOWN;
	      }
	      if(xa < 0){

	    //	  animSprite = left;
	    	  dir = Direction.LEFT;
	      }else if(xa > 0){

	    	//  animSprite = right;
	    	  dir = Direction.RIGHT;
	    	  if(x > player.getX() && x < player.getX() + 25){
	    	//	  animSprite = left;
		    	  dir = Direction.LEFT;
	    		  
	    	  }
	      } 
	       
	      
	}
   
    

	public void render(Screen screen) {
	    sprite = animSprite.getSprite();
		screen.renderMob(x , y , sprite, true);
		
	

	}
}


