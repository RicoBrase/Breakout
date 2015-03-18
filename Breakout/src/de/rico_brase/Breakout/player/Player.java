package de.rico_brase.Breakout.player;

/**
 * Repr�sentiert den aktuellen Spieler und h�lt die aktuellen Leben.
 * @author Rico Brase
 *
 */
public class Player {

	private static final int starting_lives = 3;
	
	public static Player INSTANCE;
	
	public int lives = 3; 
	
	public Player(){
		INSTANCE = this;
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
	 * Gibt zur�ck, ob der Spieler noch lebt (mehr als 0 Leben hat).
	 * @return Gibt true zur�ck, wenn der Spieler mehr als 0 Leben hat.
	 */
	public boolean isAlive(){
		return lives > 0;
	}
	
}
