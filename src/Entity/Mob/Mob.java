package Entity.Mob;

import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;
import Entity.Entity;
import Entity.Projectile;
import Entity.PlayerWizardProjectile;
import MyGame.Game;


public abstract class Mob extends Entity {

	protected boolean moving = false;
	protected boolean walking = false;
	

	public static enum Direction {
		UP, DOWN, RIGHT, LEFT;
	}
	
	public static Direction dir;
	
	public void move(int xa, int ya){ 

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
		
		}
	

	
	  public  abstract void update();
	  
	  public  abstract void render(Screen sceen);

	  protected void shoot(int x, int y, double dir){
	 
	    	Projectile p = new PlayerWizardProjectile(x, y, dir);
	    	level.addProjectile(p);
	    
	  }
	  
	  protected void mobShoot(int x, int y, double dir){
			 
	    	Projectile p = new MobWizardProjectile(x, y, dir);
	    	level.addProjectile(p);
	    
	  }
	  
	  protected void tankShoot(int x, int y, double dir){
			 
	    	Projectile p = new TankWizardProjectile(x, y, dir);
	    	level.addProjectile(p);
	    
	  }
    
	  protected void smallTankShoot(int x, int y, double dir){
			 
	    	Projectile p = new SmallTankWizardProjectile(x, y, dir);
	    	level.addProjectile(p);
	    
	  }
   
    public boolean collision(int xa, int ya){
    	   Player player = level.getClientPlayer();
    	   xScroll = player.getX() - Screen.width / 3;
		   yScroll = player.getY() - Screen.height / 3;
        
    	   boolean solid = false;
		
    	 if((x + xa) < 200 || (x + xa) > level.width * 16  - 32 || (y + ya) < 110 || (y + ya) > (level.height * 16) - 500) solid =  true;
    
    	 
    	 
    	 int x0 = xScroll >> 6; 
         int x1 = (xScroll + level.screen.width) >> 4; 
         int y0 = yScroll >> 6; 
         int y1 = (yScroll + level.screen.height) >> 4; 
     //     System.out.println(xScroll);
 		for (int yy = y0 ;yy <= y1; yy++){ // 
 			for(int xx = x0; xx <= x1; xx++){ 
 			

 			      if(level.getTile(xx,yy).solid() == true){
 			 		
 			          if((x + xa) + 32 > (xx * 16) && (x + xa) < (xx * 16) + level.getTile(xx,yy).sprite.width && (y + ya) + 48 > (yy * 16) && (y + ya) + 48 < (yy * 16) + level.getTile(xx,yy).sprite.height){
 				               solid = true;       	
 				                      		if(Mob.dir == Mob.Direction.RIGHT)  x = x -1;	                       	                       		
 				                         	if(Mob.dir == Mob.Direction.LEFT)   x = x +1;
 				                         	if(Mob.dir == Mob.Direction.UP)     y = y +3;
 				                      		if(Mob.dir == Mob.Direction.DOWN)   y = y -3; 
 			      }
	 
}
}
 		}
 		return solid;
    }
}