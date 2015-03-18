package de.rico_brase.Breakout.powerups;

import java.util.Timer;
import java.util.TimerTask;

public abstract class PowerUp {

	private int duration;
	private boolean enabled = false;
	
	public PowerUp(int duration){
		this.duration = duration;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public boolean isActive(){
		return enabled;
	}
	
	public void start(){
		
		enabled = true;
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				enabled = false;
				
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task, getDuration() * 1000);
		
		doStuff();
	}
	
	public abstract void doStuff();
	
}
