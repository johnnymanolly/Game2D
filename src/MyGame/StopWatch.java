package MyGame;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
public static int interval;
public static Timer timer;

   public StopWatch(){

    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = 150;
    
    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
        
           // System.out.println(setInterval());
        if(Game.updating) setInterval();
        }
    }, delay, period);
}
   
   
private static final int setInterval() {
	
    if (interval == 1)
        timer.cancel();
    return --interval;
}
}

