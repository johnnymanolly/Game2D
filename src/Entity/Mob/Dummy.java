package Entity.Mob;


import Entity.Entity;
import MyGame.Game;
import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Dummy extends Mob {
	
	private Animatedsprite down = new Animatedsprite(SpriteSheet.enemey_down, 32, 48, 3);
	private Animatedsprite up = new Animatedsprite(SpriteSheet.enemey_up, 32, 48, 3);
	private Animatedsprite left = new Animatedsprite(SpriteSheet.enemey_left, 32, 48, 3);
	private Animatedsprite right = new Animatedsprite(SpriteSheet.enemey_right, 32, 48, 3);
	
	private Animatedsprite animSprite = left;
	
	
	private int time = 0;
	public int xa = 0;
	public int ya = 0;

	
	public Dummy(int x, int y){
		this.x = x << 4;
		this.y = y << 4;
		sprite = animSprite.getSprite();
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
	      
	      move();
	 
	}
    
    public void move(){
        
	      if(xa != 0 || ya != 0) {
	    	     walking = true; 
	    	      move(xa,ya);
	    	       
	    	      
	            }else{
	    			walking = false;
	    		}
    }

	public void render(Screen screen) {
	    sprite = animSprite.getSprite();
		screen.renderMob(x , y , sprite, true);
		
	

	}


	

}
