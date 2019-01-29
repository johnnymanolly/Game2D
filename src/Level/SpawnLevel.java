package Level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Entity.Mob.Chasers;
import Entity.Mob.Dog;
import Entity.Mob.Dummy;
import Entity.Mob.GuardingDog;
import Entity.Mob.Shooter;
import Entity.Mob.SideTankDestroyed;
import Entity.Mob.SmallTank;
import Entity.Mob.Tank;
import Entity.Mob.TankDestroyed;
import Entity.Mob.TankSide;


public class SpawnLevel extends Level{

	public SpawnLevel(String path) {
		super(path);
		
	}

	protected void loadLevel(String path) {
		
		try{
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path)); // load image from paint.net (Level.png), then put in into Levelpixels
			int w = width = image.getWidth(); // get the width by number of pixels (16)
			int h = height = image.getHeight(); // get the height by number of pixels (16)
		
			
			// load an image and putting it into pixels
			tiles = new int[w * h]; //16 * 16
			image.getRGB(0, 0, w, h, tiles, 0, w); // (startX, startY, w, h, rgbArray, offset, scansize)
			
		} catch(IOException e){
		e.printStackTrace();
		System.out.println("Exception! could not load level file!");
}
	
	
	//	add(new SideTankDestroyed(30,13));
	
		
		add(new TankSide(300,13));
		add(new Tank(300,22));
		add(new Tank(350,13));
		add(new TankSide(380,22));
		add(new Tank(420,13));
		add(new Tank(450,22));
		add(new GuardingDog(230 + 250,13));
		add(new GuardingDog(235+ 250,24));
		add(new GuardingDog(235+ 250,15));
		add(new GuardingDog(240+ 250,17));
		add(new GuardingDog(240+ 250,20));
		add(new Chasers(120,10));
		add(new Chasers(130,20));
		add(new Shooter(125,15));
		add(new Shooter(105,10));
		add(new Chasers(200,10));
		add(new Shooter(110,20));
		add(new Shooter(140,15));
		add(new Shooter(133,10)); 
	
	
		for(int i = 0; i < 20; i+=5){
		      add(new Shooter(170 + i,15 ));  
		    
			}
		
		for(int i = 0; i < 30; i+=5){
		      add(new Dog(150 + i,15 ));  
		    
			}
		for(int i = 0; i < 30; i+=5){
		      add(new Dog(130 + i,10 ));  
		    
			}
		
			
		for(int i = 0; i < 15; i+=5){
		      add(new Dummy(150 + i,15));  
		    
			}
		for(int i = 0; i < 15; i++){
		      add(new Shooter(90 + i,15));  
		    
			}
		
		
       
         for(int i = 0; i < 20; i+=5){     
   	      add(new Chasers(110 + i,20)); 

            }
   		
         for(int i = 0; i < 20; i += 10){     
   	      add(new Shooter(120 + i,15)); 

            } 
         for(int i = 0; i < 20; i++){     
      	      add(new Shooter(200,15)); 

               } 
     	for(int i = 0; i < 150; i+=5){
		      add(new SmallTank(350 + i,15 ));  
		    
			}
         
   		
		
}

 
		

		// Grass = 0xFF00;
		// Flower = 0xFFFF00;
		// Rock = 0x7F7F00;
		protected void generateLevel(){
			
		}
		
		
		
}
