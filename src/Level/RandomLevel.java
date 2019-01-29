package Level;

import java.util.Random;

public class RandomLevel extends Level {

	private static Random random = new Random();
			
	
	public RandomLevel(int width, int height) {
		super(width, height);
	
	}
	
	protected void genrateLevel(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x + y * width] = random.nextInt(4); // assigns three integers randomlyfrom 0 to 3
			}
		}
	}

}
