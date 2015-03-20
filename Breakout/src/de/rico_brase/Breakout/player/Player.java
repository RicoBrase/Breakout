package de.rico_brase.Breakout.player;

import java.util.ArrayList;

import de.rico_brase.Breakout.powerup.PowerUps;

/**
 * Repr�sentiert den aktuellen Spieler und h�lt die aktuellen Leben.
 * @author Rico Brase
 *
 */
public class Player {

	private static final int starting_lives = 3;
	
	/**
	 * Die Instanz des aktuellen Spielers.
	 */
	public static Player INSTANCE;
	
	/**
	 * Alle derzeit aktiven PowerUps.
	 */
	public ArrayList<PowerUps> current_powerups;
	
	/**
	 * Die aktuelle Anzahl an Leben des Spielers.
	 */
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
	
	/**
	 * F�gt ein neues PowerUp zum aktiven Spieler hinzu.
	 * @param pu Das hinzuzuf�gende PowerUp.
	 */
	public void addPowerUp(PowerUps pu){
		current_powerups.add(pu);
	}
	
	/**
	 * Gibt zur�ck, ob der Spieler noch lebt (mehr als 0 Leben hat).
	 * @return Gibt true zur�ck, wenn der Spieler mehr als 0 Leben hat.
	 */
	public boolean isAlive(){
		return lives > 0;
	}
	
}
