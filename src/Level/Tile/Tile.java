package Level.Tile;

import Entity.Entity;
import graphics.Screen;
import graphics.Sprite;

public class Tile extends Entity { // each tile should have a position and a sprite, need to be rendered and recognize if solid or not
	
	//public int x, y; // Tile coordinate
	public Sprite sprite; // attach sprite into a tile
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flour = new TreeTile(Sprite.flour);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile bullet = new RocksTile(Sprite.bullet);
	public static Tile rocket = new RocksTile(Sprite.rocket);
	public static Tile shot_horizontally = new RocksTile(Sprite.shot_horizontally);
	public static Tile shot_45_up = new RocksTile(Sprite.shot_45_up);
	public static Tile shot_45_down = new RocksTile(Sprite.shot_45_down);
	public static Tile shot_vertically = new RocksTile(Sprite.shot_vertically);
	public static Tile dead_dog = new DeadDogTile(Sprite.dead_dog);
	public static Tile dead_body = new DeadDogTile(Sprite.dead_body1);
	public static Tile small_tank_bullet = new DeadDogTile(Sprite.small_tank_bullet);
	
	public static Tile helicopter = new HelicopterTile(Sprite.helicopter);
        

	public static Tile three_houses = new HouseTile(Sprite.three_house);
	public static Tile lake = new LakeTile(Sprite.lake);
	public static Tile hotel = new HotelTile(Sprite.hotel);
	public static Tile rocks = new RocksTile(Sprite.rocks);
	public static Tile house = new HouseTile(Sprite.house);
	public static Tile big_grass = new BigGrassTile(Sprite.big_grass);
	public static Tile grass_spot = new GrassSpot(Sprite.grass_spot);
	public static Tile construction = new ConstructionTile(Sprite.construction);
     
        
	public static Tile voidTile = new voidTile(Sprite.voidSprite);
	
	 
	 
	 
	 
	 
	 
	 
	 public static final int col_spawn_grass = 0xff00FF00;
	 public static final int col_spawn_rock = 0xff7F7F00;
	 public static final int col_spawn_flour = 0xffFFFF00;
         
         public static final int col_spawn_three_house = 0xffFF0000;
         public static final int col_spawn_lake = 0xff00FFFF;
         public static final int col_spawn_hotel = 0xffFF6A00;
         public static final int col_spawn_rocks = 0xff606000;
         public static final int col_spawn_house = 0xffC60000;
         public static final int col_spawn_big_grass = 0xff005600; 
         public static final int col_spawn_grass_spot = 0xff008200;
         public static final int col_spawn_construction = 0xff7F0000;
         
         public static final int col_spawn_helicopter = 0xff404040;
    
	
	
	// every time we create a tile we need to attach a sprite to it using this constructor
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}

	// set x and y to set the position of the tile on the screen, needs to be in every single tile
	public void render(int x, int y, Screen screen){
		
	}
	
	public boolean solid(){
		return false;
	}
	
	public boolean is_Solid(){
	
		return false;

	}
}
