package Entity;

import graphics.Animatedsprite;
import graphics.Screen;
import graphics.Sprite;

import java.util.Random;






import Entity.Mob.Player;
import Level.Level;
import Level.Tile.Tile;
import MyGame.Game;
import MyGame.SoundsEffect;

	public class Entity { // Entity is the head of the all mobs
		
		public int x,y; // x and y control the location of a particular Entity on the map
		protected Sprite sprite;
		private boolean removed = false;
		protected Level level;
		protected final Random random = new Random();
		protected SoundsEffect effect = new SoundsEffect();
		protected int xScroll;
		protected int yScroll;
		protected Tile tile;
		
		public static int mobs = 0;
		public static int hyena = 0;
		public static int tanks = 0;
		public static int score = 0;
		public static int bonus = 0;
		public static int health = 500;
		public static int upgrade = 50;
		public static boolean upgraded = false;
		
		public Screen screen;
		public static int xDog, yDog;
		
		public Entity(){
			
		}
		
        public Entity(int x, int y, Sprite sprite){
        	this.x = x;
        	this.y = y;
        	this.sprite = sprite;
          
        	
        } 
		
        public int getX(){
        	return x;
        }
        
        public void setX(int x){
        	this.x = x;
        }
        
        public int getY(){
        	return y;
        }
        
        public void setY(int y){
        	this.y = y;
        }
        
		public void update(){
			
		}
		
		public void render(Screen screen){
			if(sprite != null) screen.renderPlayer(x, y, sprite);
			
		}
		
		
		public void remove(){
			// remove from Level
			removed = true;
		}
		
		public Sprite getSprite(){
			return sprite;
		}
		
		public boolean isRemoved(){
			return removed;
		}
		
		public void init(Level level){
			this.level = level;
		}
		   
	}


