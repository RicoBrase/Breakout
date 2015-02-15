package de.rico_brase.Breakout.ballmovement;

import java.util.Random;

public class Rotation{
	private static int angle = Directions.UP.getAngle();
	private static Random rand = new Random();
	
	public static void setAngle(int angle){
		Rotation.angle = angle;
	}
	
	public static int getAngle(){
		return angle;
	}
	
	public static void bounce(){
		
		
		
	}
}