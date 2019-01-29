package MyGame;

import java.io.*;
import java.util.Random;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundsEffect {
    
	protected final Random random = new Random();
	private String groan;
	private String body_fall;
	private String shout;
	private String machine_gun;
	private String walk;
	private String shot;
	private String misson_completed;
	private String hyena;
	private String tank_shoot;
	private String tank_explosion;
	private String upgrade;
	private String helicopter;
	private String khodyer;
	
	public SoundsEffect(){
		groan =  "res/sounds/Mobs/Groan_00"+ random.nextInt(13) +"a.wav";
		body_fall = "res/sounds/Mobs/BodyFall_00"+ random.nextInt(2)+".wav";
		shout = "res/sounds/Player/Shout_00" +random.nextInt(2)+"a.wav";
		machine_gun = "res/sounds/Player/Machinegun_00" + random.nextInt(2) +".wav";
		walk = "res/sounds/Player/Walk.wav";
		shot = "res/sounds/Mobs/Shot_00" + random.nextInt(3) +".wav";
		misson_completed = "res/sounds/Player/Mission_Completed.wav";
		hyena = "res/sounds/Mobs/Hyena_001.wav";
		tank_shoot = "res/sounds/Tanks/tankshoot.wav";
		tank_explosion = "res/sounds/Tanks/Explosion_00"+ random.nextInt(6) +".wav";
		upgrade = "res/sounds/Player/Upgrade.wav";
		helicopter = "res/sounds/Helicopter.wav";
		khodyer = "res/sounds/Player/khodyer.wav";
	}
	
	public void groan(){
		try {
			
			InputStream in = new FileInputStream(groan);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void bodyFall(){
		try {
			
			InputStream in = new FileInputStream(body_fall);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void shout(){
		try {
			
			InputStream in = new FileInputStream(shout);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void machineGun(){
		try {
			
			InputStream in = new FileInputStream(machine_gun);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void walk(){
		try {
			
			InputStream in = new FileInputStream(walk);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void shot(){
		try {
			
			InputStream in = new FileInputStream(shot);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void missionCompleted(){
		try {
			
			InputStream in = new FileInputStream(misson_completed);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void hyena(){
		try {
			
			InputStream in = new FileInputStream(hyena);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tankShoot(){
		try {
			
			InputStream in = new FileInputStream(tank_shoot);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void tankExplosion(){
		try {
			
			InputStream in = new FileInputStream(tank_explosion);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void upgrade(){
		try {
			
			InputStream in = new FileInputStream(upgrade);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Helicopter(){
		try {
			
			InputStream in = new FileInputStream(helicopter);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void khodyer(){
		try {
			
			InputStream in = new FileInputStream(khodyer);
			
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
