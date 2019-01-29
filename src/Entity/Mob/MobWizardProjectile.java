package Entity.Mob;

import graphics.Screen;
import Entity.Projectile;
import Level.Tile.Tile;
import MyGame.Game;

public class MobWizardProjectile extends Projectile{
    
	public static final int FIRE_RATE = 7;
	public MobWizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		speed = 9;
		range = 3000;
		damage = 20;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		
		tile = Tile.shot_horizontally;
		if(dir > 0.3) tile = Tile.shot_45_down;
		if(dir > 1.0) tile = Tile.shot_vertically;
		if(dir > 1.3) tile = Tile.shot_horizontally;
		if(dir <-0.3) tile = Tile.shot_45_up;
		if(dir <-1.0) tile = Tile.shot_vertically;
		if(dir <-1.3) tile = Tile.shot_horizontally;
	
	}
	
	 public void update(){
		 playerCollision();
    	 if(collision()) remove();
    	 move();
     }
	 
	 public void move(){
		 x += nx;
		 y += ny;
		 if(distance() > range) remove();
	}
         
         public double distance(){
        	 double dist = 0;
        	 
        	 dist = Math.sqrt(Math.abs(xOrigin - x) * ((xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
        	 
        	 return dist;
         }
         public void render(Screen screen){
        	 screen.renderFire((int)x , (int)y + 10, tile);
         }
         
         
         public void playerCollision(){
        	   
        	 int xxx = (int) x;
        	 int yyy = (int) y;
        	 
        	 Player player = level.getClientPlayer();
        	 if((xxx > player.getX()  && xxx < player.getX() + 10 && yyy > player.getY() - 20 && yyy < player.getY() - 20 + 48)){
        		health--; 
        		remove();
        		effect.shout();
        	 }
        
         } 
         
         public boolean collision(){
        	   Player player = level.getClientPlayer();
        	   xScroll = player.getX() - Screen.width / 3;
    		   yScroll = player.getY() - Screen.height / 3;
         	 boolean solid = false;        	 
        	 int x0 = xScroll >> 6; 
             int x1 = (xScroll + level.screen.width) >> 4; 
             int y0 = yScroll >> 6; 
             int y1 = (yScroll + level.screen.height) >> 4; 
               
     		for (int yy = y0 ;yy <= y1; yy++){ // 
     			for(int xx = x0; xx <= x1; xx++){ 
     			

     			      if(level.getTile(xx,yy).solid() == true){
     			 		
if(x > (xx * 16) && x < (xx * 16) + level.getTile(xx, yy).sprite.width &&  y > (yy * 16) + 20 && y < (yy * 16) + 20 + level.getTile(xx, yy).sprite.height + 10){
                    	remove();
                    	solid = true;
                 }
     			
     				                      	
     			          }
     			      }
        	 
     			      }
        	 
     		
     		return solid;
         }

}
