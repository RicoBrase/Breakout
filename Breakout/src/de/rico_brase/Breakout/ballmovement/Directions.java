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
	
	public static Directions getDirectionByAngle(int angle){
		
		if(angle >= RIGHT.getAngle()/2 && angle < RIGHT.getAngle()/2) return RIGHT;
		if(angle >= DOWN.getAngle()/2 && angle < DOWN.getAngle()/2) return DOWN;
		if(angle >= LEFT.getAngle()/2 && angle < LEFT.getAngle()/2) return LEFT;
		if(angle >= UP.getAngle()/2 && angle < UP.getAngle()/2) return UP;
		
		return null;
	}
	
}
