package de.rico_brase.Breakout.ballmovement;

public class MovementUtils {

	public static double getDirectionX(int rotation){
		return Math.cos(Math.toRadians(rotation));
	}
	
	public static double getDirectionY(int rotation){
		return Math.sin(Math.toRadians(rotation));
	}
	
	public static double getVelocity(double direction, double speed){
		return direction * speed;
	}
	
}
