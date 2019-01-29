package Entity.Mob;


import java.util.List;

import Entity.Mob.Mob.Direction;
import MyGame.Game;
import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Chasers extends Mob{
	private Animatedsprite down = new Animatedsprite(SpriteSheet.enemey_down, 32, 48, 3);
	private Animatedsprite up = new Animatedsprite(SpriteSheet.enemey_up, 32, 48, 3);
	private Animatedsprite left = new Animatedsprite(SpriteSheet.enemey_left, 32, 48, 3);
	private Animatedsprite right = new Animatedsprite(SpriteSheet.enemey_right, 32, 48, 3);
	
	private Animatedsprite animSprite = left;
	
	private int time = 0;
	public int xa = 0;
	public int ya = 0;

	
	public Chasers(int x, int y){
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

	}
	
	public void attack(){
		xa = 0;
    	ya = 0;
    	Player player = level.getClientPlayer();
		if(x < player.getX() + 20) xa = 1;
		if(x > player.getX() + 20) xa = -1;
		if(y < player.getY() + 15) ya = 1;
		if(y > player.getY() + 15) ya = -1;
   
       if(x <= player.getX() + 20 && y <= player.getY() + 20){
    	 //  animSprite = dog_damage;
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
    	if(x < player.getX() + 100) attack();
	   
  
   
      if(walking){ animSprite.update();
      } else{
    	  animSprite.setFrame(0);
      
      }
     
  	  if(ya < 0) {
			
			  animSprite = up;
			  dir = Direction.UP;
			  
		  }else if(ya > 0){
			  
	    	  animSprite = down;
	    	  dir = Direction.DOWN;
	      }
	      if(xa < 0){

	    	  animSprite = left;
	    	  dir = Direction.LEFT;
	      }else if(xa > 0){

	    	  animSprite = right;
	    	  dir = Direction.RIGHT;
	      }
	          move();
	          
		      double dx = player.getX() - x;
		      double dy = player.getY() - y;
		      double dir = Math.atan2(dy, dx);
		     
		    	  if(x < player.getX() + 200 && (x > player.getX() - 50)){
		    		  if(time % (random.nextInt(5) + 80) == 0){
		    		  mobShoot(x,y,dir);
		    		  effect.shot();
		    	  }
		      }
		
	      
	   
	}

	public void render(Screen screen) {
	    sprite = animSprite.getSprite();
		screen.renderMob(x , y , sprite, true);
		
	

	}
}


	