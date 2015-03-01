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
	
	public static int invert(int angle){
		return validateAddAngle(180, angle);
	}
	
	public static void addAngle(int angleBonus) {
		angle = validateAddAngle(angleBonus, getAngle());
		//angle += angleBonus;
	}
	
	public static int mirrorAngle(int angle, Directions lot){
		
		int finalAngle = validateAddAngle(180, angle);
		
		finalAngle = (lot.getAngle() - finalAngle) + lot.getAngle();
		
		return finalAngle;
	}
	
	private static int validateAddAngle(int a, int angle){ //90
		
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