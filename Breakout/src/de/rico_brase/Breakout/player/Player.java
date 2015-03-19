package de.rico_brase.Breakout.player;

import java.util.ArrayList;

import de.rico_brase.Breakout.powerup.PowerUps;

/**
 * Repräsentiert den aktuellen Spieler und hält die aktuellen Leben.
 * @author Rico Brase
 *
 */
public class Player {

	private static final int starting_lives = 3;
	
	public static Player INSTANCE;
	
	public ArrayList<PowerUps> current_powerups;
	
	public int lives = 3; 
	
	public Player(){
		INSTANCE = this;
		current_powerups = new ArrayList<PowerUps>();
	}
	
	/**
	 * Reduziert die Anzahl der aktuellen Leben des Spielers um 1.
	 */
	public void die(){
		lives--;
	}
	
	/**
	 * Resettet die Lebensanzahl.
	 */
	public void reset(){
		lives = starting_lives;
	}
	
	public void addPowerUp(PowerUps pu){
		current_powerups.add(pu);
	}
	
	/**
	 * Gibt zurück, ob der Spieler noch lebt (mehr als 0 Leben hat).
	 * @return Gibt true zurück, wenn der Spieler mehr als 0 Leben hat.
	 */
	public boolean isAlive(){
		return lives > 0;
	}
	
}
