package Entity.Mob;

import Entity.Mob.Mob.Direction;
import MyGame.Game;
import graphics.Animatedsprite;
import graphics.Screen;
import graphics.SpriteSheet;

public class GuardingDog extends Mob {

	
	private Animatedsprite left = new Animatedsprite(SpriteSheet.dog_left, 63, 34, 3);
	private Animatedsprite right = new Animatedsprite(SpriteSheet.dog_right, 63, 34, 3);
	private Animatedsprite dog_damage = new Animatedsprite(SpriteSheet.dog_damage, 63, 34, 4);
	
	private Animatedsprite animSprite = left;
	
	private int time = 0;
	public int xa = 0;
	public int ya = 0;
	
	public GuardingDog(int x, int y){
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
	
	public void attack(){
		xa = 0;
    	ya = 0;
    	Player player = level.getClientPlayer();
		if(x < player.getX() + 20) xa = 1;
		if(x > player.getX() + 20) xa = -1;
		if(y < player.getY() + 15) ya = 1;
		if(y > player.getY() + 15) ya = -1;
   
		 if(x <= player.getX() + 20 && x >= player.getX() && y <= player.getY() + 15 && y >= player.getY()){
    	   animSprite = dog_damage;
    	   health--; 
    	
    	   if(health < 0) health = 0;
    	 //  player.setX(205);
       }
	}
	
	public void moveRandomly(){
		time++;

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
	    if(x < player.getX() + 150) attack();
	    move();
   
      if(walking){ animSprite.update();
      } else{
    	  animSprite.setFrame(0);
      
      }
     
  	  if(ya < 0) {
			
			  animSprite = right;
			  dir = Direction.UP;
			  
		  }else if(ya > 0){
			  
	    	  animSprite = right;
	    	  dir = Direction.DOWN;
	      }
	      if(xa < 0){

	    	  animSprite = left;
	    	  dir = Direction.LEFT;
	      }else if(xa > 0){

	    	  animSprite = right;
	    	  dir = Direction.RIGHT;
	    	  if(x > player.getX() && x < player.getX() + 25){
	    		  animSprite = left;
		    	  dir = Direction.LEFT;
	    		  
	    	  }
	      } 
	       
	}
   
    

	public void render(Screen screen) {
	    sprite = animSprite.getSprite();
		screen.renderMob(x , y , sprite, true);
		
	

	}
}


