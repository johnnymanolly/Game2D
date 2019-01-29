package Entity;

import Level.Tile.Tile;
import graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin,yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx,ny;
	protected double speed, range, damage;
	protected double distance;
	protected double x,y;
	public Projectile(int x, int y, double dir ){
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}
	
	protected void move(){
		
	}
}
