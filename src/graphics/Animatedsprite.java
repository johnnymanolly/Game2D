package graphics;

public class Animatedsprite extends Sprite {

	private int frame = 0;
	private Sprite sprite;
	private int rate = 8;
	private int length;
	private int time = 0;
	
	
	public Animatedsprite(SpriteSheet sheet, int width, int height, int length) {
		super(sheet, width, height);
	    this.length = length; // = 3
	    sprite = sheet.getSprites()[0];
	    if(length > sheet.getSprites().length)  System.err.println("Error! Lenght of animation is too long!");
	}
	
	  public void update(){
		if(time < 7500) time++;
		else time = 0;
		if(time % rate == 0){
		if(frame >= length -1) frame = 1;
		else frame++;
		sprite = sheet.getSprites()[frame];
	
		}
	}
	  public void updateOnce(){
			 time++;
			
				    
			if(time % rate == 0){
			sprite = sheet.getSprites()[frame];			
			if(frame >= length -1) sprite = sheet.getSprites()[3];
			else frame++;
			}
		
		}
	
	public Sprite getSprite(){
		return sprite;
		
	}
	
	public void setFrameRate(int frames){
		
		rate = frames;
		
		
		
	}
	
	public boolean stopFrames(){
		boolean condition = false;
		if(frame > sheet.getSprites().length - 1) {
			condition = true;
		}
		return condition;
	}

	public void setFrame(int i) {
		if(frame > sheet.getSprites().length - 1){
			System.err.println("index out of bound in " + this);
			return;
		}
			sprite = sheet.getSprites()[0];
		
		
	}

}
