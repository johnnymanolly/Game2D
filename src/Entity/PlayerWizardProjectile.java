package Entity;

import graphics.Screen;
import Entity.Mob.Chasers;
import Entity.Mob.DeadBody1;
import Entity.Mob.DeadBody2;
import Entity.Mob.DeadBody3;
import Entity.Mob.DeadDog;
import Entity.Mob.Dog;
import Entity.Mob.Dummy;
import Entity.Mob.GuardingDog;
import Entity.Mob.Player;
import Entity.Mob.Shooter;
import Entity.Mob.SideTankDestroyed;
import Entity.Mob.SmallTank;
import Entity.Mob.SmallTankDestroyed;
import Entity.Mob.Tank;
import Entity.Mob.TankDestroyed;
import Entity.Mob.TankSide;
import Input.Keyboard;
import Level.Tile.Tile;

public class PlayerWizardProjectile extends Projectile {
	
	
	public static int FIRE_RATE = 3;
	public int timer = 0;
	public int counter = 0;


	public PlayerWizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		speed = 20;
		range = 4000;
		damage = 20;

		// create a vector for shooting
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
	    	 if(score > upgrade){
	    	 if(Player.two){
					tile = Tile.rocket;
			        
				}
	    	 }
	    
	         if(timer < 7500) timer++;
	         else timer = 0;
	    	 if(collision() || level.tileCollision(x, x, nx, ny, 16)) remove();
	    
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
        	 screen.renderFire((int)x + 15 , (int)y + 9 , tile);
         }

         
         public boolean collision(){
        	   Player player = level.getClientPlayer();
        	   xScroll = player.getX() - Screen.width / 3;
    		   yScroll = player.getY() - Screen.height / 3;
        	
        	 int xxx = (int) x;
        	 int yyy = (int) y;
        	 if(xxx > player.getX() + (Screen.width / 2) + 50) remove();
        	 for(int i = 0; i < level.mobs.size(); i++){
        
        		 if(xxx > level.mobs.get(i).getX() && xxx < level.mobs.get(i).getX() + level.mobs.get(i).sprite.width && yyy > level.mobs.get(i).getY() - 20 && yyy < level.mobs.get(i).getY() -20 + level.mobs.get(i).sprite.height){
        			 
        			 if(level.mobs.get(i) instanceof Dummy) {
        				 
        				 level.add(new DeadBody2(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
        				 mobs++;
        				 remove();
        				 level.mobs.remove(i);
        				 effect.groan();
        				 effect.bodyFall();
        			 }
        			 else if(level.mobs.get(i) instanceof Shooter) {
        				 level.add(new DeadBody1(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
        				 mobs++;
        				 remove();
        				 level.mobs.remove(i);
        				 effect.groan();
        				 effect.bodyFall();
        			 }
        			 else if(level.mobs.get(i) instanceof Chasers){
        				 level.add(new DeadBody3(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
        				 remove();
        				 level.mobs.remove(i);
        				 mobs++;
        				 bonus++; 
        				 effect.groan();
        				 effect.bodyFall();
        			 }
        			 else if(level.mobs.get(i) instanceof Dog){
        	             hyena++;
        				 level.add(new DeadDog(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
        		    	 level.mobs.remove(i);
        		    	 remove();
        		    	 effect.bodyFall();
        		    	 effect.hyena();
        				 
        			 }
                        else if(level.mobs.get(i) instanceof GuardingDog){
        	             hyena++;
        				 level.add(new DeadDog(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
        		    	 level.mobs.remove(i);
        		    	 remove();
        		    	 effect.bodyFall();
        		    	 effect.hyena();
        				 
        			 }
        			 
                        else if(level.mobs.get(i) instanceof Tank && tile == Tile.rocket){
                         level.add(new TankDestroyed(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
           	             tanks++;          	
           		    	 level.mobs.remove(i);
           		    	 remove();
           		    	effect.tankExplosion();
           		
           				 
           			 }
                        else if(level.mobs.get(i) instanceof TankSide && tile == Tile.rocket){
                        	 level.add(new SideTankDestroyed(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() - 50 >> 4));
                        	tanks++;
              		    	 level.mobs.remove(i);
              		    	 remove();
              		    	effect.tankExplosion();
              				 
              			 }
                        else if(level.mobs.get(i) instanceof SmallTank && tile == Tile.rocket){
                        	 level.add(new SmallTankDestroyed(level.mobs.get(i).getX() >> 4,level.mobs.get(i).getY() >> 4));
              		    	 level.mobs.remove(i);
              		    	 remove();
              		    	 effect.tankExplosion();
              		        	tanks++;
              		
              				 
              			 }
        			    
        			
        		 }
        		 
        	 }
        	
        	     score = mobs + hyena + tanks + bonus;
        	   
        	   
         	 boolean solid = false;        	 
        	 int x0 = xScroll >> 6; 
             int x1 = (xScroll + level.screen.width) >> 4; 
             int y0 = yScroll >> 6; 
             int y1 = (yScroll + level.screen.height) >> 4; 
       
     		for (int yy = y0 ;yy <= y1; yy++){ // 
     			for(int xx = x0; xx <= x1; xx++){ 
     			

     			      if(level.getTile(xx,yy).solid() == true){
     			 		
if(xxx + 35 > (xx * 16) && xxx  < (xx * 16) + level.getTile(xx, yy).sprite.width - 20 &&  (yyy) + 20 > (yy * 16) && (yyy) < (yy * 16) + level.getTile(xx, yy).sprite.height - 19){
                    	remove();
                    	solid = true;
                 }
     			
     				                      	
     			          }
     			      }
        	 
     			      }
        	 
     		
     		return solid;
         }
         
         
}