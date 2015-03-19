package de.rico_brase.Breakout.powerup;

import java.awt.Graphics2D;
import java.util.ArrayList;

import de.rico_brase.Breakout.paddle.Paddle;
import de.rico_brase.Breakout.scenes.game.SceneGame;

public class PowerUpManager {

	private static ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
	
	public static void add(PowerUp pu){
		if(pu != null) powerups.add(pu);
	}
	
	public static void handlePowerUpManagement(Graphics2D g){
		
		if(powerups.isEmpty()) return;
		
		@SuppressWarnings("unchecked")
		ArrayList<PowerUp> pu_cloned = (ArrayList<PowerUp>) powerups.clone();
		
		
		for(PowerUp pu : pu_cloned){
			pu.yPos += 5;
			pu.xPos = pu.spawnLoc.getXPos() + (SceneGame.blockWidth/2)-20;
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
