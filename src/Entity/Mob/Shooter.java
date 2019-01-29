package Entity.Mob;

import graphics.Animatedsprite;
import graphics.Screen;
import graphics.SpriteSheet;
import MyGame.Game;

public class Shooter extends Mob{
	
	private Animatedsprite down = new Animatedsprite(SpriteSheet.enemey_down, 32, 48, 3);
	private Animatedsprite up = new Animatedsprite(SpriteSheet.enemey_up, 32, 48, 3);
	private Animatedsprite left = new Animatedsprite(SpriteSheet.enemey_left, 32, 48, 3);
	private Animatedsprite right = new Animatedsprite(SpriteSheet.enemey_right, 32, 48, 3);
	
	private Animatedsprite animSprite = left;
	

	private int time = 0;
	public int xa = 0;
	public int ya = 0;
	public static boolean shooter = false;

	
	public Shooter(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = animSprite.getSprite();
	}
	public void update() {
	
		Player player = level.getClientPlayer();
    	if(x == player.getX() && y == player.getY()) player.setX((Game.getwidth() / 3) + 1);
    	if(time < 1000) time++;
    	else time = 0;

        if(time % (random.nextInt(50) + 30) == 0){
        	xa = random.nextInt(3) - 1;
        	ya = random.nextInt(3) - 1;
        	if(random.nextInt(4) == 0){
        		xa = 0;
        		ya = 0;
        	}
        }  
 
      if(walking){ animSprite.update();
      } else{
    	  animSprite.setFrame(1);
      
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
	      
	      
	      
	      if(xa != 0 || ya != 0) {
	    	    walking = true;
	    		if(xa > 0) dir = Direction.RIGHT; // EAST
	    		if(xa < 0) dir = Direction.LEFT; // WEST
	    		if(ya > 0) dir = Direction.DOWN; // SOUTH
	    		if(ya < 0) dir = Direction.UP; // NORTH
	    	  
	    		if(!collision(xa,0) ){
	    			x += xa; // increase x 1 per loop
	    		}
	    		if(!collision(0,ya) ){
	    			y += ya;
	    	     	}
	    		
	    		
	      }else{
	    			walking = false;
	    		}
	      double dx = player.getX() - x;
	      double dy = player.getY() - y;
	      double dir = Math.atan2(dy, dx);
	      if(time % (random.nextInt(5) + 30) == 0){
	    	  if(x < player.getX() + 400 && (x > player.getX() - 50)){
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
