package de.rico_brase.Breakout.player;

public class Player {

	private static final int starting_lives = 3;
	
	public static Player INSTANCE;
	
	public int lives = 3; 
	
	public Player(){
		INSTANCE = this;
	}
	
	public void die(){
		lives--;
	}
	
	public void reset(){
		lives = starting_lives;
	}
	
	public boolean isAlive(){
		return lives > 0;
	}
	
}
