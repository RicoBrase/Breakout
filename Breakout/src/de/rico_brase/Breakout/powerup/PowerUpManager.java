package de.rico_brase.Breakout.powerup;

import java.awt.Graphics2D;
import java.util.ArrayList;

import de.rico_brase.Breakout.paddle.Paddle;
import de.rico_brase.Breakout.scenes.game.SceneGame;

/**
 * Diese Klasse handhabt die PowerUp-Verwaltung.
 * @author Rico Brase
 *
 */
public class PowerUpManager {

	/**
	 * Alle derzeit existenten PowerUp-Instanzen.
	 */
	private static ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	
	/**
	 * F�gt eine PowerUp-Instanz zum Handler hinzu.
	 * @param pu Das hinzuzuf�gende PowerUp.
	 */
	public static void add(PowerUp pu){
		if(pu != null) powerups.add(pu);
	}
	
	/**
	 * Diese Methode ist f�r die PowerUp-"Magie" zust�ndig.
	 * Sie �berpr�ft f�r jedes PowerUp in der oben definierten ArrayList, ob es das Paddle ber�hrt (eingesammelt wurde) und startet entweder dessen Effekt oder l�sst das PowerUp einen Schritt nach unten machen. 
	 * Zudem sorgt diese Methode daf�r, dass jedes PowerUp auch auf dem Spielfeld gerendert wird.
	 * 
	 * @param g
	 */
	public static void handlePowerUpManagement(Graphics2D g){
		
		if(powerups.isEmpty()) return;
		
		@SuppressWarnings("unchecked")
		ArrayList<PowerUp> pu_cloned = (ArrayList<PowerUp>) powerups.clone();
		
		
		for(PowerUp pu : pu_cloned){
			pu.xPos = pu.spawnLoc.getXPos() + (SceneGame.blockWidth/2)-20;
			if(pu.yPos <= 10) pu.yPos = pu.spawnLoc.getYPos() + (SceneGame.blockHeight/2)-20;
			pu.yPos += 5;
			pu.renderPowerUp(g);
			if(pu.xPos+40 >= (Paddle.getXPos() - (Paddle.width/2)) && pu.xPos <= (Paddle.getXPos() + (Paddle.width/2))){
				if(pu.yPos + 20 >= Paddle.getYPos()){
					pu.start();
					powerups.remove(pu);
				}
			}
			
		}
	}
	
}
