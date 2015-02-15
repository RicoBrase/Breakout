package de.rico_brase.Breakout.ballmovement;

public enum Directions {

	RIGHT(0),
	DOWN(90),
	LEFT(180),
	UP(270);
	
	private int rotation;
	
	private Directions(int rotation){
		this.rotation = rotation;
	}
	
	public int getAngle(){
		return this.rotation;
	}
	
}
