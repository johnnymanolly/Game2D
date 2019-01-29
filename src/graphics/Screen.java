package graphics;

import java.util.Random;

import Entity.Mob.Chasers;
import Entity.Mob.Dummy;
import Entity.Mob.Mob;
import Level.Tile.Tile;


public class Screen {
	public static int width;
	public static int height;
	
	private int[] tiles = new int[64 * 64]; // = 4096
	private Random random = new Random();
	
	public static int xoffset, yoffset;
	
	public int[] pixels;
	int ytime = 0;
	int xtime = 20;

	
	Tile tile;
	

	private int xa =0;
	private int ya =0;


	
	public Screen(int width, int height){
     this.width = width;	
     this.height = height;
     pixels = new int[width * height];
     
     for(int i = 0;i < 64 * 64; i++){
    	 tiles[0] = 0x0000000;
    	 tiles[i] = random.nextInt(0xffffff); // colors each pixel randomly
    	 
     }
	}

	public void renderPlayer(int xp, int yp, Sprite sprite){
	
		
		for(int y = 0; y < sprite.height; y++){
			int yy = yp + y - yoffset;
					
			for (int x = 0; x < sprite.width; x++){
				int xx = xp + x - xoffset;
			
				if(xx < -32 || xx >= width || yy < 0 || yy >= height) break; // make sure you only render what you see on the screen
                if(xx < 0) xx = 0;
				
		if((sprite.pixels[(x)+(y) * sprite.width] != 0xff505050) && (sprite.pixels[(x)+(y) * sprite.width] != 0xff53678D)){
		pixels[xx +(yy * width)] = sprite.pixels[(x)+(y) * sprite.width]; // xx,yy : coordinates of player
		}
		
	   }
	  }
	
	}
	
	public void renderMob(int xp, int yp, Sprite sprite, boolean fixed){
		
		if(fixed){
			xp -= xoffset;
			yp -= yoffset;
		}
		
		
		for(int y = 0; y < sprite.height; y++){
			int yy = yp + y;
	
					
			for (int x = 0; x < sprite.width; x++){
				int xx = xp + x;
			 
			
				if(xx < -200 || xx >= width || yy < 0 || yy >= height) break; // make sure you only render what you see on the screen
                if(xx < 0) xx = 0;

                
                int color = 0xff505050;
                int color2 = 0xff53678D;
                int tank_color = 0xffFFFFFF;
                int tank_color2 = 0xff546D8E;
                int small_tank_color = 0xff69A6F9;
		if((sprite.pixels[(x)+(y) * sprite.width] != color) && (sprite.pixels[(x)+(y) * sprite.width] != color2) && (sprite.pixels[(x)+(y) * sprite.width] != tank_color) && (sprite.pixels[(x)+(y) * sprite.width] != tank_color2) && (sprite.pixels[(x)+(y) * sprite.width] != small_tank_color)){		
	    if(sprite.pixels[(x)+(y) * sprite.width] == 0xff00BB00 || sprite.pixels[(x)+(y) * sprite.width] == 0xff006600) sprite.pixels[(x)+(y) * sprite.width] =  0xffFF7700;
	    if(sprite.pixels[(x)+(y) * sprite.width] == 0xff004400|| sprite.pixels[(x)+(y) * sprite.width] == 0xff008800) sprite.pixels[(x)+(y) * sprite.width] =  0xff9B7700;
	    	

		pixels[xx +(yy * width)] = sprite.pixels[(x)+(y) * sprite.width]; // xx,yy : coordinates of player
		}
		
	   }
  }
	
	}

	
	public void renderMob(int xp, int yp, Mob mob){
		
		xp -= xoffset;
		yp -= yoffset;
	
	   for(int y = 0; y < 48; y++){
		int ya = yp + y;
		int ys = y;
				
		for (int x = 0; x < 32; x++){
			int xa = xp + x;
		    int xs = x;
			if(xa < -32 || xa >= width || ya < 0 || ya >= height) break; // make sure you only render what you see on the screen
            if(xa < 0) xa = 0;
			
            int col = mob.getSprite().pixels[xs + ys * 32];
            if((mob instanceof Chasers) && col == 0xff004400)  col = 0xffC63848;
            if(col != 0xff505050) pixels[xa +(ya * 32)] = col;
            
	}
	
   }
  }



	public void renderRecTile(int xp, int yp, Tile tile){
		
		for(int y = 0; y < tile.sprite.height; y++){
			int yy = yp + y - yoffset ;
		
			for(int x = 0; x < tile.sprite.width; x++){
				int xx = xp + x - xoffset;
			
				if(xx < -tile.sprite.width || xx >= width || yy < 0 || yy >= height) break; // make sure you only render what you see on the screen
                if(xx < 0) xx = 0;
				
                if(tile.sprite.pixels[(x)+(y)*tile.sprite.width] != 0xff10A01E && (tile.sprite.pixels[(x)+(y)*tile.sprite.width] != 0xffFFFFFF)){
             
				 pixels[xx +(yy * width)] = tile.sprite.pixels[x  + y   * tile.sprite.width];
                
                } else {  
                	if(x > 15 || y > 15) continue;
    				pixels[xx  +(yy * width)] = Sprite.grass.pixels[x  + y   * Sprite.grass.width];
    				
                }  
              
		}
	}
	}

	public void renderTile(int xp, int yp, Tile tile){
    
				for(int y = 0; y < tile.sprite.width; y++){	
		 
	          	 ya =   yp + y - yoffset; // -offset lets us render from 0; 
		  
		   for(int x = 0; x < tile.sprite.width; x++){
			
	              xa =  xp + x - xoffset ; 
	      //      System.out.println("xa = " +xa);
                  
	              if(xa < -tile.sprite.width || xa >= width || ya < 0 || ya >= height) break; // if xa > 500 => do nothing and skip
	                if(xa < 0) xa = 0;
	                
	                if(pixels[xa+ya*width] != 0) continue; // if pxl is already colored => skip
	                
			
	                if(tile.sprite.pixels[(x)+(y)*tile.sprite.width]!=0xff10A01E){ // color only the sprite without its background color
	
				pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.width]; // xa, ya ar the coordinates of the tile on the screen
                        
			} else { // colors green the unrendered areas - otherwise it will show as black
			
				pixels[xa +(ya * width)] = Sprite.grass.pixels[x  + y   * Sprite.grass.width];
			}
			
			
	                
	                
			}
		   }
		
	}
		
	
	public void renderFire(int xp, int yp, Tile tile){
	    
		for(int y = 0; y < tile.sprite.width; y++){	
 
      	 ya =   yp + y - yoffset; // -offset lets us render from 0; 
  
   for(int x = 0; x < tile.sprite.width; x++){
	
          xa =  xp + x - xoffset ; 
  //      System.out.println("xa = " +xa);
          
          if(xa < -tile.sprite.width || xa >= width || ya < 0 || ya >= height) break; // if xa > 500 => do nothing and skip
            if(xa < 0) xa = 0;
            
            if(pixels[xa+ya*width] != 0) continue; // if pxl is already colored => skip
            
	
            if((tile.sprite.pixels[(x)+(y)*tile.sprite.width]!=0xff10A01E) && (tile.sprite.pixels[(x)+(y)*tile.sprite.width]!=0xff69A6F9)){ // color only the sprite without its background color

		pixels[xa+ya*width] = tile.sprite.pixels[x+y*tile.sprite.width]; // xa, ya ar the coordinates of the tile on the screen
                
	} 
	
            
            
	}
   }

}
	
	public void renderEnemy(int xp, int yp){
		for(int y = 0; y < Sprite.enemy.height; y++){
			int yy = yp + y - yoffset;
					
			for (int x = 0; x <Sprite.enemy.width; x++){
				int xx = xp + x - xoffset;
			
				if(xx < -32 || xx >= width || yy < 0 || yy >= height) break; // make sure you only render what you see on the screen
                if(xx < 0) xx = 0;
				
		if(Sprite.enemy.pixels[(x)+(y) * Sprite.enemy.width] != 0xff505050){
		pixels[xx +(yy * width)] = Sprite.enemy.pixels[(x)+(y) * Sprite.enemy.width]; // xx,yy : coordinates of player
		}
		
	   }
	  }
	
	}
	
	public void rendersheet(int xp, int yp, SpriteSheet sheet, boolean fixed){
		if(fixed){
			xp -= xoffset;
			yp -= yoffset;
		}
		
		for(int y = 0; y < sheet.height; y++){
			int ya = yp + y;
			for(int x = 0; x < sheet.width; x++){
			int xa = xp + x;
			if(xa < 0 || xa > width || ya < 0 || ya > height) continue;
			pixels[xa + ya * width] = sheet.pixels[x + y * sheet.width];
			}
		}
		
	}
	
	public void clear(){
	       for(int i=0 ; i<pixels.length; i++){
	           pixels[i] = 0;
	       }
	}

	public void setoffset(int xoffset, int yoffset){
		this.xoffset = xoffset;
		this.yoffset = yoffset;
	}

	
	
	
	
	
	
	
	
	
	public void renderMap(int xoffset, int yoffset ){
		
		
		for(int y = 0; y < height; y++){
		
			int yy = y + yoffset;
			if(ytime < 0 || ytime >= height) continue; // when it gets to the edge of the screen it will continue, handles the out bound Exception
			for (int x = 0; x < width; x++){
				int xx = x + xoffset;
				if(xtime < 0 || xtime >= width) continue;
				
				
			
			  	pixels[x +(y * width)] = Sprite.grass.pixels[(xx & 15) + (yy & 15)   * Sprite.grass.SIZE]; // colors every pixel red
				
		
			}
			
		}
	  }











   public void renderTiles(int xoffset, int yoffset){
     
      for( int y = 0; y < height; y++ ){
    	  int yy = y + yoffset;

    	  for (int x = 0; x < width; x++){
    		  int xx = x + xoffset;

    		  

    		
    		  pixels[x + (y * width)] = tiles[((xx / 16)& 7 )  + (( yy / 16)& 7)  * 64]; // "xx / 16" creates tiles of 16 * 16, "& 7" creates loop of 8 tiles
    	  }
      }
   }
}
   
   
   
   
 /*  	public void renderTest(int xp, int yp){
		for(int y = 0; y < Tile.house.sprite.height; y++){
			int yy = yp + y;
					
			for (int x = 0; x < Tile.house.sprite.width; x++){
				int xx = x + xp;
				
		
		
		pixels[xx +(yy * width)] = Tile.house.sprite.pixels[(x)+(y) * Tile.house.sprite.width]; // xx,yy : coordinates of player
		}
		
	   }
	  }
	
	}

*/