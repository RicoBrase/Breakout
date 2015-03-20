package de.rico_brase.Breakout.powerup;

import java.util.Random;

import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.powerup.powerups.FlamePowerUp;
import de.rico_brase.Breakout.powerup.powerups.HealthPowerUp;
import de.rico_brase.Breakout.powerup.powerups.PaddlePowerUp;

/**
 * Eine Auflistung aller möglichen PowerUp-Effekte.
 * TODO Verschieben der Dauer und der Spawnchance aus den PowerUp-Klassen in diese Enumeration.
 * 
 * @author Rico Brase
 *
 */
public enum PowerUps {

	FLAME(new FlamePowerUp()),
	PADDLE_LENGTH(new PaddlePowerUp()),
	EXTRA_LIFE(new HealthPowerUp());
	
	private PowerUp pu;
	
	private PowerUps(PowerUp pu){
		this.pu = pu;
	}
	
	/**
	 * Gibt eine Instanz der zugehörigen PowerUp-Klasse zurück.
	 * Diese wird nicht an den {@link de.rico_brase.Breakout.powerup.PowerUpManager PowerUpManager} übergeben.
	 * @return Eine PowerUp-Instanz.
	 */
	public PowerUp getPowerUp(){
		return this.pu;
	}
	
	/**
	 * Ermittelt, ob und welches PowerUp spawnen soll.
	 * @param block Der Block, von welchem aus das PowerUp spawnen soll.
	 * @return Ein zufälliges PowerUp oder null.
	 */
	public static PowerUp getRandomPowerUp(Block block){
		
		Random rand = new Random();
		
		for(PowerUps pus : PowerUps.values()){
			if(rand.nextDouble() <= 0.3){
				if(rand.nextDouble() <= pus.getPowerUp().getChance()){
					PowerUp new_pu;
					try {
						new_pu = pus.getPowerUp().getClass().getConstructor().newInstance();
						new_pu.spawnLoc = block;
						return new_pu;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return null;
	}
	
	
}
