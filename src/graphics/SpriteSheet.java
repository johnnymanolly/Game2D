package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpriteSheet {
	
	public int SIZE;
	public int[] pixels;
	private String path;
	public int width;
	public int height;
	
	
	public static SpriteSheet sheet = new SpriteSheet("/textures/spritesheet.png",256);
	public static SpriteSheet sheet_bigTiles = new SpriteSheet("/textures/spritesheet_bigTiles.png",800);
	public static SpriteSheet sheet_shooter = new SpriteSheet("/textures/sheet_shooter.png",226,514);
	public static SpriteSheet tank = new SpriteSheet("/textures/tank.png",488,362);
	public static SpriteSheet tank_small = new SpriteSheet("/textures/tank.gif",636,326);
	public static SpriteSheet helicopter = new SpriteSheet("/textures/Helicopter.png",2154,976);
	
	public static SpriteSheet tank_destroyed = new SpriteSheet("/textures/Tank_destroyed.png",800,90);
	public static SpriteSheet tank_destroyed_anim = new SpriteSheet(tank_destroyed, 0, 0, 4, 1, 202, 89);
	
	public static SpriteSheet side_tank_destroyed = new SpriteSheet("/textures/SideTankDestroyed.png",600,120);
	public static SpriteSheet side_tank_destroyed_anim = new SpriteSheet(side_tank_destroyed, 0, 0, 4, 1, 148, 120);
	
	public static SpriteSheet dog = new SpriteSheet("/textures/dog.png",444,103);	
	public static SpriteSheet sheet_shooter_enemy = new SpriteSheet("/textures/sheet_shooter_enemy.png",194,480);
	
	public static SpriteSheet enemey_down  = new SpriteSheet(sheet_shooter_enemy, 0, 5, 3, 1, 32, 48);
	public static SpriteSheet enemey_up    = new SpriteSheet(sheet_shooter_enemy, 0, 1, 3, 1, 32, 48);
	public static SpriteSheet enemey_left  = new SpriteSheet(sheet_shooter_enemy, 0, 7, 3, 1, 32, 48);
	public static SpriteSheet enemey_right = new SpriteSheet(sheet_shooter_enemy, 0, 2, 3, 1, 32, 48);
	
	public static SpriteSheet dog_right  = new SpriteSheet(dog, 0, 0, 3, 1, 63, 34);
	public static SpriteSheet dog_left = new SpriteSheet(dog, 3, 0, 3, 1, 63, 34);
	public static SpriteSheet dog_damage = new SpriteSheet(dog, 1, 1, 4, 1, 63, 34);
	
	public static SpriteSheet tank_rotation = new SpriteSheet(tank_small, 0, 2, 9, 1, 71, 64);
	public static SpriteSheet small_tank_destroyed = new SpriteSheet(tank_small, 0, 3, 8, 1, 73, 66);
	
	
    public Sprite[] sprites;
	
	
	public SpriteSheet(String path, int size){
		this.path = path;
		SIZE = size * size;
		pixels = new int[SIZE];
		this.width = size;
		this.height = size;
		load();
		
	}
	
	public SpriteSheet(String path, int width, int height){
		SIZE = width * height;
		this.path = path;
		this.width = width;
		this.height = height;
		pixels = new int[SIZE];
		load();
	}
	
	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSizeWidth, int spriteSizeHeight){
		int xx = x * spriteSizeWidth;
		int yy = y * spriteSizeHeight;
		int w = width * spriteSizeWidth;
		int h = height * spriteSizeHeight;
		this.width = w;
		this.height = h;
		pixels = new int[w * h];
		
		for(int y0 = 0; y0 < h; y0++){
			int yp = yy + y0;
		for(int x0 = 0; x0 < w; x0++){
			int xp = xx + x0;
			
			pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.width];
		  }	
		}
		   int frame = 0;
		   sprites = new Sprite[width * height];
		   for(int ya = 0; ya < height; ya++){
			   for(int xa = 0; xa < width; xa++){
				 int[] spritePixels  = new int[spriteSizeWidth * spriteSizeHeight];
				   for(int y0 = 0; y0 < spriteSizeHeight ; y0++){
					   for(int x0 = 0; x0 < spriteSizeWidth; x0++){
				 
						   spritePixels[x0 + y0 * spriteSizeWidth] = pixels[(x0 + xa * spriteSizeWidth) + (y0 + ya * spriteSizeHeight) * this.width];
			              
					   }
		   }
				   Sprite sprite = new Sprite(spritePixels, spriteSizeWidth, spriteSizeHeight);
				   sprites[frame++] = sprite;			   }
	
		   }
	}

	      public Sprite[] getSprites(){
	    	return sprites;
	}

	public void load(){
		
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); // get the RGB color from a portion and set them as integers in an array
			
		} catch (IOException e) {			
			e.printStackTrace();
		
		}
	}
	

		
	}