package de.rico_brase.Breakout.powerup;

import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.player.Player;

/**
 * Diese abstrakte Klasse repräsentiert ein PowerUp auf dem Spielfeld.
 * @author Rico Brase
 *
 */
public abstract class PowerUp {

	private int duration;
	private double chance;
	
	public int xPos = 0;
	public int yPos = 0;
	
	public Block spawnLoc = null;
	
	public PowerUps power_up;
	
	public PowerUp(int duration, double chance){
		this.duration = duration;
		this.chance = chance;
	}
	
	/**
	 * Gibt die Dauer des Effektes des PowerUps zurück.
	 * @return Die Dauer des Effektes.
	 */
	public int getDuration(){
		return duration;
	}
	
	/**
	 * Gibt die Wahrscheinlichkeit zurück, mit der ein PowerUp gespawnt wird.
	 * @return Die Chance auf dieses PowerUp.
	 */
	public double getChance(){
		return this.chance;
	}
	
	/**
	 * "Startet" den Effekt des PowerUps, der in der {@link de.rico_brase.Breakout.powerup.PowerUp#doStuff() doStuff()}-Methode definiert wurde.
	 * Die meisten Effekte werden allerdings in den Klassen eingebaut, in denen das PowerUp einen Effekt erzielen soll.
	 * Zum Beispiel für das "Flame"-PowerUp in der {@link de.rico_brase.Breakout.ball.Ball Ball}-Klasse.
	 */
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
	
	/**
	 * @see de.rico_brase.Breakout.powerup.PowerUp#start()
	 */
	public abstract void doStuff();
	
	/**
	 * Rendert das PowerUp auf dem Spielfeld.
	 * @param g
	 */
	public abstract void renderPowerUp(Graphics2D g);
	
}
