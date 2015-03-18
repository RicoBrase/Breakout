package de.rico_brase.Breakout.ballmovement;

/**
 * Diese Klasse enthält Methoden, die zur Berechnung der neuen Position des Balls (zur Bewegung) anhand des Winkels benötigt werden.
 * @author Rico Brase
 *
 */
public class MovementUtils {

	/**
	 * Berechnet den 
	 * @param rotation
	 * @return
	 */
	public static double getDirectionX(int rotation){
		return Math.cos(Math.toRadians(rotation));
	}
	
	/**
	 * 
	 * @param rotation
	 * @return
	 */
	public static double getDirectionY(int rotation){
		return Math.sin(Math.toRadians(rotation));
	}
	
	/**
	 * 
	 * @param direction
	 * @param speed
	 * @return
	 */
	public static double getVelocity(double direction, double speed){
		return direction * speed;
	}
	
}
