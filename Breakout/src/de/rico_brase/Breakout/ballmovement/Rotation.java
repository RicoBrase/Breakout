package de.rico_brase.Breakout.ballmovement;

import java.util.Random;

public class Rotation{
	private static int angle = Directions.UP.getAngle();
	public static Random rand = new Random();
	
	public static void setAngle(int angle){
		Rotation.angle = validateSetAngle(angle);
	}
	
	public static int getAngle(){
		return angle;
	}
	
	public static void invert(){
		addAngle(180);
	}

	public static void addAngle(int angleBonus) {
		angle = validateAddAngle(angleBonus);
		//angle += angleBonus;
	}
	
	private static int validateAddAngle(int a){ //90
		
		int newAngle = angle + a; //270 + 90 = 360
		int finalAngle = newAngle; // 360
		
		while(finalAngle >= 360){
			finalAngle = finalAngle - 360;
		}
		
		while(finalAngle < 0){
			finalAngle = finalAngle + 360;
		}
		
		return finalAngle;
	}
	
	private static int validateSetAngle(int a){
		int finalAngle = a;
		
		while(finalAngle >= 360){
			finalAngle = finalAngle - 360;
		}
		
		while(finalAngle < 0){
			finalAngle = finalAngle + 360;
		}
		
		return finalAngle;
	}
	
}