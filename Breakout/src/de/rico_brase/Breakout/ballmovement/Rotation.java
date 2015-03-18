package de.rico_brase.Breakout.ballmovement;

import java.util.Random;

/**
 * Enthält Methoden, die für die Rotation des Balls zuständig sind.
 * @author Rico Brase
 *
 */
public class Rotation{
	private static int angle = Directions.UP.getAngle();
	public static Random rand = new Random();
	
	/**
	 * Setzt den Winkel des Balls. Wird auf den Bereich [0-359] zugeschnitten.
	 * @param angle Der neue Winkel des Balls.
	 */
	public static void setAngle(int angle){
		Rotation.angle = validateSetAngle(angle);
	}
	
	/**
	 * 
	 * @return Der aktuelle Winkel des Balls.
	 */
	public static int getAngle(){
		return angle;
	}
	
	/**
	 * Berechnet den Gegenwinkel der angegebenen Rotation.
	 * @param angle Die angegebene Rotation.
	 * @return Der Gegenwinkel zur gegebenen Rotation
	 */
	public static int invert(int angle){
		return validateAddAngle(180, angle);
	}
	
	/**
	 * Dreht den Ball um die gegebene Rotation.
	 * @param angleBonus
	 */
	public static void addAngle(int angleBonus) {
		angle = validateAddAngle(angleBonus, getAngle());
		//angle += angleBonus;
	}
	
	/**
	 * Gibt den Ausfallswinkel des gegebenen Winkels an dem Lot an.
	 * @param angle Der Einfallswinkel.
	 * @param lot Das Lot zur Rotation.
	 * @return Der Ausfallswinkel.
	 */
	public static int mirrorAngle(int angle, Directions lot){
		
		int finalAngle = validateAddAngle(180, angle);
		
		finalAngle = (lot.getAngle() - finalAngle) + lot.getAngle();
		
		return finalAngle;
	}
	
	/**
	 * Validiert die Addition zweier Winkel miteinander. Bereich: [0-359]
	 * @param a Der ursprüngliche Winkel.
	 * @param angle Die zu addierende Winkelgröße.
	 * @return Die Summer beider Winkel.
	 */
	private static int validateAddAngle(int a, int angle){
		
		int newAngle = angle + a;
		int finalAngle = newAngle;
		
		while(finalAngle >= 360){
			finalAngle = finalAngle - 360;
		}
		
		while(finalAngle < 0){
			finalAngle = finalAngle + 360;
		}
		
		return finalAngle;
	}
	
	/**
	 * Validiert das Setzen eines Winkels. Bereich: [0-359]
	 * @param a Die neue Winkelgröße.
	 * @return Die validierte Winkelgröße.
	 */
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