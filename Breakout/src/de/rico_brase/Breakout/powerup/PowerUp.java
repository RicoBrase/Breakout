package de.rico_brase.Breakout.powerup;

import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.player.Player;

public abstract class PowerUp {

	private int duration;
	private double chance;
	private boolean enabled = false;
	
	public int xPos = 0;
	public int yPos = 0;
	
	public Block spawnLoc = null;
	
	public PowerUps power_up;
	
	public PowerUp(int duration, double chance){
		this.duration = duration;
		this.chance = chance;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public double getChance(){
		return this.chance;
	}
	
	public boolean isActive(){
		return enabled;
	}
	
	public void start(){
		
		for(PowerUps pus : PowerUps.values()){
			if(pus.getPowerUp().getClass() == this.getClass()){
				power_up = pus;
			}
		}
		
		Player.INSTANCE.addPowerUp(power_up);
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				
				Player.INSTANCE.current_powerups.remove(power_up);
				
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task, getDuration() * 1000);
		
		doStuff();
	}
	
	public abstract void doStuff();
	
	public abstract void renderPowerUp(Graphics2D g);
	
}
