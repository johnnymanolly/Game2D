package graphics;

import java.util.Random;


public class Sprite {
	
	public int SIZE;
	public int width;
	public int height;
	private int x ,y; // coordinates of the sprites in the grid image
	public int[] pixels;
	protected SpriteSheet sheet;
	
	Random random = new Random();

	 public static Sprite grass = new Sprite(16,0,0,SpriteSheet.sheet);
	 public static Sprite flour = new Sprite(16,3,0,SpriteSheet.sheet);
	 public static Sprite rock = new Sprite(16,4,0,SpriteSheet.sheet);
	 public static Sprite bullet = new Sprite(16,15,3,SpriteSheet.sheet);
	 public static Sprite small_tank_bullet = new Sprite(16,15,2,SpriteSheet.sheet);
	 public static Sprite rocket = new Sprite(16,15,0,SpriteSheet.sheet);
	 public static Sprite shot_horizontally = new Sprite(16,12,1,SpriteSheet.sheet);
	 public static Sprite shot_45_up = new Sprite(16,13,1,SpriteSheet.sheet);
	 public static Sprite shot_45_down = new Sprite(16,14,1,SpriteSheet.sheet);
	 public static Sprite shot_vertically = new Sprite(16,15,1,SpriteSheet.sheet);
	 
	 public static Sprite tank = new Sprite(12 * 16 , 4 * 16, 12,6,SpriteSheet.tank);
	 public static Sprite tank_up = new Sprite(12 * 16 , 4 * 16, 0,6,SpriteSheet.tank);
	 public static Sprite tank_side_up = new Sprite(10 * 16 , 4 * 16, 4,11,SpriteSheet.tank);
	 public static Sprite tank_side = new Sprite(10 * 16 , 4 * 16, 14,11,SpriteSheet.tank);
	 
	 public static Sprite helicopter = new Sprite(24 * 16 , 7 * 16, 1,0,SpriteSheet.helicopter);
         
          public static Sprite three_house = new Sprite(240,64,26,6,SpriteSheet.sheet_bigTiles);
          public static Sprite lake = new Sprite(80,48,37,1,SpriteSheet.sheet_bigTiles);
          public static Sprite hotel = new Sprite(190,64,25,1,SpriteSheet.sheet_bigTiles);
          public static Sprite rocks = new Sprite(128,60,1,1,SpriteSheet.sheet_bigTiles);
          public static Sprite house = new Sprite(80,60,42,1,SpriteSheet.sheet_bigTiles);
          public static Sprite big_grass = new Sprite(96,68,19,1,SpriteSheet.sheet_bigTiles);
          public static Sprite grass_spot = new Sprite(80,48,9,1,SpriteSheet.sheet_bigTiles);
          public static Sprite construction = new Sprite(230,48,11,6,SpriteSheet.sheet_bigTiles);
          
          public static Sprite dummy = new Sprite(32,48,0,0,SpriteSheet.sheet_shooter);
          
          
	 public static Sprite voidSprite = new Sprite(16,0x1B87E0);
	 
	 
	 public static Sprite dead_dog = new Sprite(63,34,24,4,SpriteSheet.dog);
	 public static Sprite dead_body1 = new Sprite(48,32,12,2,SpriteSheet.sheet);
	 public static Sprite dead_body2 = new Sprite(48,32,12,4,SpriteSheet.sheet);
	 public static Sprite dead_body3 = new Sprite(48,32,12,6,SpriteSheet.sheet);
	 
	// public static Sprite shooter = new Sprite(32,48,0,1,SpriteSheet.sheet);
	 
	 public static Sprite shooter_frd_1 = new Sprite(32,48,3,7,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_frd_2 = new Sprite(32,48,3,10,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_frd_3 = new Sprite(32,48,4,4,SpriteSheet.sheet);
	 public static Sprite shooter_frd_4 = new Sprite(32,48,5,7,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_frd_5 = new Sprite(32,48,11,7,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_frd_6 = new Sprite(32,48,1,7,SpriteSheet.sheet_shooter);
	 
	 public static Sprite shooter_back_1 = new Sprite(32,48,1,19,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_back_2 = new Sprite(32,48,3,19,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_back_3 = new Sprite(32,48,4,7,SpriteSheet.sheet);
	 public static Sprite shooter_back_4 = new Sprite(32,48,3,22,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_back_5 = new Sprite(32,48,5,22,SpriteSheet.sheet_shooter);
	 public static Sprite shooter_back_6 = new Sprite(32,48,1,22,SpriteSheet.sheet_shooter);
	 
	 public static Sprite shooter_down_1 = new Sprite(32,48,0,10,SpriteSheet.sheet);
	 public static Sprite shooter_down_2 = new Sprite(32,48,2,10,SpriteSheet.sheet);
	 public static Sprite shooter_down_3 = new Sprite(32,48,4,10,SpriteSheet.sheet);
	 public static Sprite shooter_down_4 = new Sprite(32,48,6,10,SpriteSheet.sheet);
	 public static Sprite shooter_down_5 = new Sprite(32,48,8,10,SpriteSheet.sheet);
	 public static Sprite shooter_down_6 = new Sprite(32,48,10,10,SpriteSheet.sheet);
	 
	 public static Sprite shooter_up_1 = new Sprite(32,48,0,13,SpriteSheet.sheet);
	 public static Sprite shooter_up_2 = new Sprite(32,48,2,13,SpriteSheet.sheet);
	 public static Sprite shooter_up_3 = new Sprite(32,48,4,13,SpriteSheet.sheet);
	 public static Sprite shooter_up_4 = new Sprite(32,48,6,13,SpriteSheet.sheet);
	 public static Sprite shooter_up_5 = new Sprite(32,48,8,13,SpriteSheet.sheet);
	 public static Sprite shooter_up_6 = new Sprite(32,48,10,13,SpriteSheet.sheet);
         
        
	 
	 
	 public static Sprite enemy = new Sprite(32,48,0,7,SpriteSheet.sheet);
	 
	 
	 
	 
	 public Sprite(SpriteSheet sheet, int width, int height){
		 SIZE = width * height;
		 this.width = width;
		 this.height = height;
		 pixels = new int[SIZE];
		 this.sheet = sheet;
	 }
	 
	 
	 
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size * size;
         this.width = size;
		this.height = size;
		this.x = x * size;
		this.y = y * size;
		pixels = new int[SIZE];
		load(sheet);
		}
	
	public void load(SpriteSheet sheet){ // y * size = 0 || 16 || 32 || 64 .. || 256
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				pixels[x + (y * width)] = sheet.pixels[(x + this.x ) + (y + this.y )* sheet.width]; // load 16 pixels ( one sprite) from sheet and put them in Sprite pixels
			}
	}
		
	}
	
	 public Sprite(int width, int height, int x, int y, SpriteSheet sheet){
		SIZE = width * height;
		this.width = width;
		this.height = height;
		this.x = x * 16; // sprites are either 16 px or divided per 16; sprite can consist of two block of 16px each
		this.y = y * 16;
		pixels = new int[SIZE];
		loadWH(sheet);
		
	}
	 
		
		public void loadWH(SpriteSheet sheet){ // load RECSprite from sheet
			for(int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					
					pixels[x + y * width] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.width];
		}
		
	}
	}
	
	 public Sprite(int size, int colour){ // for the void tile
	    	SIZE = size;
	    	pixels = new int[SIZE * SIZE];
	    	setColour(colour);
	    }
	 
	   public Sprite(int[] pixels, int width, int height) {
		SIZE = width * height;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}



	private void setColour(int colour) {
			
			for(int i = 0; i < SIZE * SIZE; i++){
				pixels[i] = colour;
			}
		}
	


}