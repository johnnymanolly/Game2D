package Level;

import graphics.Screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Entity.Entity;
import Entity.Projectile;
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
import Level.Tile.Tile;

public class Level extends Entity {
	
	public Screen screen;
	public int width,height;
	public int[] tiles; // we have filled the array with pixels from the spwan_level class, tiles is full
	Entity entity = new Entity();
	Random random = new Random();
	
	public List<Entity> mobs = new ArrayList<Entity>();	
	public List<Projectile> projectiles = new ArrayList<Projectile>();
	
	public List<Player> players = new ArrayList<Player>();
	int counterx = 0;
	
	
	public static Level spawn = new SpawnLevel("/Level/Level1.png");

	
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
		
	}
	
	public Level(String path){ // path is specified in SpwanLevel class
		loadLevel(path); // method is overrided in v
		generateLevel();
		
	}
	
	protected void generateLevel(){ // create random Level from SpwanLevel class method
		
	}
	
	protected void loadLevel(String path){
		
	}

	
	public void render(int xScroll, int yScroll, Screen screen){ // corner pins;defines the rendering range of the LEVEL MAP according to the player's position
		screen.setoffset(xScroll, yScroll); // to delete the offset range
         
		// consider Xscroll not moving and analyze the method code
		int x0 = xScroll >> 6; 
        int x1 = (xScroll + screen.width) >> 4; 
        int y0 = yScroll >> 6; 
        int y1 = (yScroll + screen.height) >> 4; 
    //    System.out.println(xScroll);
		for (int yy = y0 ;yy <= y1; yy++){ // 
			for(int xx = x0; xx <= x1; xx++){ 
				getTile(xx,yy).render(xx, yy, screen);

	          		}
		
			for(int i = 0; i < mobs.size(); i++){
				mobs.get(i).render(screen);
			}
			for(int i = 0; i < projectiles.size(); i++){
				projectiles.get(i).render(screen);
			}
			for(int i = 0; i < players.size(); i++){
			players.get(i).render(screen);
		//		System.out.println("X: " +(players.get(i).x));
			//	System.out.println("Y: " +(players.get(i).y));
		    	
	    	}
		}

	}
	
	
		
		
	
	public List<Player> getPlayers(){
		return players;
	}
     
	public Player getPlayerAt(int index){
		return players.get(index);
	}
	
	public Player getClientPlayer(){
		return players.get(0);		
	}
	
	public List<Entity> getEntities(Entity e, int radius){
		List<Entity> result = new ArrayList<Entity>();
		int ex = e.getX();
		int ey = e.getY();
		for(int i = 0; i < mobs.size(); i ++){
			Entity entity = mobs.get(i);
			int x = entity.getX();
			int y = entity.getY();		
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx) + (dy *dy));
			if(distance <= radius) result.add(entity);	
		}
		return result;
	}
	
	public List<Player> getPlayers(Entity e, int radius){
		int ex = e.getX();
		int ey = e.getY();
		List<Player> result = new ArrayList<Player>();
		for(int i = 0; i < players.size(); i ++){
			Player player = players.get(i);
			int x = player.getX();
			int y = player.getY();		
			int dx = Math.abs(x - ex);
			int dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx) + (dy *dy));
			if(distance <= radius) result.add(player);

		}
		return result;
	}
	
	
	public Tile getTile(int x, int y){
		
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile; // handle out of bound Exception - return EXIT THE LOOP!!
		
		if(tiles[x+y*width] == Tile.col_spawn_grass) return Tile.grass;
		if(tiles[x+y*width] == Tile.col_spawn_flour) return Tile.flour;
		if(tiles[x+y*width] == Tile.col_spawn_rock) return Tile.rock;
                
                if(tiles[x+y*width] == Tile.col_spawn_three_house) return Tile.three_houses;
                if(tiles[x+y*width] == Tile.col_spawn_lake) return Tile.lake;
                if(tiles[x+y*width] == Tile.col_spawn_hotel) return Tile.hotel;
                if(tiles[x+y*width] == Tile.col_spawn_rocks) return Tile.rocks;
                if(tiles[x+y*width] == Tile.col_spawn_house) return Tile.house;
                if(tiles[x+y*width] == Tile.col_spawn_big_grass) return Tile.big_grass;
                if(tiles[x+y*width] == Tile.col_spawn_grass_spot) return Tile.grass_spot;
                if(tiles[x+y*width] == Tile.col_spawn_construction) return Tile.construction;
                if(tiles[x+y*width] == Tile.col_spawn_helicopter) return Tile.helicopter;
               
		return Tile.voidTile;
		
	}
	
	public List<Projectile> getProjectiles(){
		return projectiles;
	}
	
	public void update(){
		
		for(int i = 0; i < mobs.size(); i++){
			mobs.get(i).update();
		}
		for(int i = 0; i < projectiles.size(); i++){
			projectiles.get(i).update();
		}
		for(int i = 0; i < players.size(); i++){
			players.get(i).update();
		}
		remove();
	}
	
	public void remove(){
		for(int i = 0; i < mobs.size(); i++){
			if(mobs.get(i).isRemoved()) mobs.remove(i);
		}
		for(int i = 0; i < projectiles.size(); i++){
			if(projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for(int i = 0; i < players.size(); i++){
			if(players.get(i).isRemoved()) players.remove(i);
		}
		
	}
	private void time(){
		
	}
	
	
	
  public void add(Entity e){
	  e.init(this);
	  
	  if(e instanceof Projectile){
		  projectiles.add((Projectile) e);
	  }else if(e instanceof Player){
		  players.add((Player) e);
	  }else if((e instanceof Dummy) || (e instanceof Chasers) || (e instanceof Shooter) || (e instanceof Dog) || (e instanceof DeadDog) || (e instanceof GuardingDog) || (e instanceof Tank) || (e instanceof DeadBody1) || (e instanceof DeadBody2) || (e instanceof DeadBody3) || (e instanceof TankSide) || (e instanceof SmallTank) || (e instanceof SmallTankDestroyed)|| (e instanceof TankDestroyed) || (e instanceof SideTankDestroyed)){
     	  mobs.add(e);
	  }
	 //   mobs.add(e);
  }
	
	public void addProjectile(Projectile p){
		p.init(this);
		projectiles.add(p);
		
	}


public boolean tileCollision(double x, double y, double xa, double ya, int size){
	boolean solid = false;
 	for (int c = 0; c < 4; c++){
 		int xt = (((int)x + (int)xa) + c % 2 * size - 30) / 16;
 		int yt = (((int)y + (int)ya) + c / 2 * size - 30)  / 16;
	    if(getTile(xt,yt).solid()) {
	//	System.out.println("Collision");
		solid = true;
	}
	
 	}
	return solid;
  }

}

	