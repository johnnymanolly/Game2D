package Entity.Mob;

import graphics.Screen;
import graphics.Sprite;
import Entity.PlayerWizardProjectile;
import Entity.Projectile;
import Input.Keyboard;
import Input.Mouse;
import Level.Tile.Tile;
import MyGame.Game;
import MyGame.SoundsEffect;



public  class Player extends Mob {

	
	private Keyboard input; // for the player
	private Sprite sprite;
	private int anim;
	public static int gunShots = 0;
	private int fireRate = 0;
	double dir2;
	private String dir = "";
	private int rate1 = 15;
	private int rate2 = 16;
	public static boolean playerShooting = false;
    public int timer = 0;
    public static boolean two = false;
    public static boolean one = false;

    
	public Player(Keyboard input){ // create a player in a default location
		this.input = input;
		sprite = Sprite.shooter_frd_1;

	}
	public Player(int x, int y, Keyboard input){ // create a player in a specific location
		this.x = x; // set the variable x in the Entity 
		this.y = y;
		this.input = input;
		sprite = Sprite.shooter_frd_6;
		fireRate = PlayerWizardProjectile.FIRE_RATE;
		
	
	}
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	
		
	
	public void update(){ 
	
		if(input.two){
			two = true;
			upgraded = true;

		}
		if(input.one){

			one = true;
		}
		
		
		xScroll = x - (Game.getwidth() / 3);
		yScroll = y - (Game.getheight() /3);
		if(fireRate > 0) fireRate--;
		int xa = 0, ya = 0; // set xa and ya to 0 everytime it enters the loop
		if(anim < 7500) anim++;
	    	else anim = 0;
		
		  if(input.up) {
			  sprite = Sprite.shooter_up_1;
			  dir = "UP";
			  ya=-1;
			
		
		  }
	      if(input.down){
	    	  sprite = Sprite.shooter_down_1;
	    	  dir = "DOWN";
	    	  ya=1;
	   
	    
	      }
	      if(input.left){
	    	  sprite = Sprite.shooter_back_1;
	    	  dir = "LEFT";
	    	  xa=-1;
	
	      }
	      if(input.right){
	    	  sprite = Sprite.shooter_frd_6;
	    	  dir = "RIGHT";
	    	  xa=1;
	   
	      }
	    
	      if(Mouse.getButton() == 1) gunShots++;
	      if(xa != 0 || ya != 0) {
	    	  move(xa, ya);                   // if xa or ya != 0 => apply the move method
	      walking = true;}
	      
	      else{
	    	  walking = false;
	    	  }
       //    System.out.println("Player X: " +(x << 4));
	      clear();
	      updateShooting();
	   //   System.out.println(playerShooting);
	     //   if(walking) effect.walk();
		  }
	
	
	private void clear() {
		for(int i = 0; i < level.getProjectiles().size(); i++){
			Projectile p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
		}
		
	}
	private void updateShooting(){
		if(Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getwidth()/3;
			double dy = Mouse.getY() - Game.getheight()/3;
			 
			 effect.machineGun();
			 dir2 = Math.atan2(dy, dx);
	
		     shoot(x, y, dir2);
		    
		//     System.out.println(dy);
			 fireRate = PlayerWizardProjectile.FIRE_RATE;
			
		
			
		}
	}
	
	public void updateDirection(){

		if(dir == "RIGHT"){ // if input.right is true
			sprite = Sprite.shooter_frd_6;
                      
		  if(walking){
			  sprite = Sprite.shooter_frd_2;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_frd_2;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_frd_3;
           
		}
		  
		  if(walking && Mouse.getButton() == 1){
			  sprite = Sprite.shooter_frd_6;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_frd_1;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_frd_4;
           
		}
		  
	
		  if(walking && Mouse.getButton() == 1 && (dir2 < -1.5 || dir2 > 1.5)){
			  sprite = Sprite.shooter_back_5;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_back_5;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_back_6;
			
           
		}
		
		}
		
		if(dir == "LEFT"){ 
			sprite = Sprite.shooter_back_1;
			
			if(Mouse.getButton() == 1) sprite = Sprite.shooter_back_6;
			
			
		  if(walking){
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_back_2;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_back_3;
	          
		  }
		  if(walking && Mouse.getButton() == 1){
			  sprite = Sprite.shooter_back_6;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_back_4;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_back_5;
		  }		  
		  

		  if(walking && Mouse.getButton() == 1 && (dir2 > -1.5 || dir2 < 1.5)){
			  sprite = Sprite.shooter_frd_6;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_frd_1;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_frd_4;
           
		}
		  if(walking && Mouse.getButton() == 1 && (dir2 < -1.5 || dir2 > 1.5)){
			  sprite = Sprite.shooter_back_6;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_back_4;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_back_5;
           
		}
		  
  
		}

		
		if(dir == "DOWN"){ 
			sprite = Sprite.shooter_down_1;
		  if(walking){
			  sprite = Sprite.shooter_down_2;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_down_2;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_down_3;
	          
		  }
		}
		
		if(dir == "UP"){ 
			sprite = Sprite.shooter_up_1;
		  if(walking){
			  sprite = Sprite.shooter_up_2;
			  if(anim % rate1 > 0)   sprite = Sprite.shooter_up_2;
	          if(anim % rate2 > 5)  sprite = Sprite.shooter_up_3;
	     
		  }
		}
		
	}

	public void render(Screen screen){

		updateDirection();
		screen.renderPlayer(x, y, sprite); 
		
	}


}
