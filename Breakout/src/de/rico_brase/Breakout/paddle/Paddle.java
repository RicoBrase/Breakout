package de.rico_brase.Breakout.paddle;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.powerups.PowerUps;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Diese Klasse repräsentiert das Paddle.
 * @author Rico Brase
 *
 */
public class Paddle {

	public static int width = 500;
	public static final int height = 25;
	
	private static int xPos = 0;
	private static int yPos = 0;
	
	public static boolean reset = true;
	
	/**
	 * Rendert das Paddle.
	 * @param g
	 */
	public static void renderPaddle(Graphics2D g){
		
		if(reset){
			width = Screen.INSTANCE.getWidth()/(PowerUps.PADDLE_LENGTH.getPowerUp().isActive() ? 1 : 6);
			xPos = Screen.INSTANCE.getWidth()/2;
			reset = false;
		}
		
		width = Screen.INSTANCE.getWidth()/(PowerUps.PADDLE_LENGTH.getPowerUp().isActive() ? 1 : 6);
		
		yPos = Screen.INSTANCE.getHeight() - height - 50;
		
		RenderManager.renderImageFromAssetsAt(Assets.Game.BAR, xPos-width/2, yPos, width, height, g);
	}
	
	/**
	 * Setzt die x-Position des Paddles.
	 * @param xPos Die neue x-Position des Paddles.
	 */
	public static void setXPos(int xPos){
		//Bar.xPos = xPos;
		
		if(xPos > Paddle.xPos){
			Paddle.xPos = Paddle.xPos + (xPos-Paddle.xPos);
		}else if(xPos < Paddle.xPos){
			Paddle.xPos = Paddle.xPos - (Paddle.xPos - xPos);
		}else{
			
		}
	}
	
	/**
	 * Gibt die aktuelle Y-Position des Paddles zurück.
	 * @return Die aktuelle y-Position des Paddles.
	 */
	public static int getYPos(){
		return yPos;
	}
	
	/**
	 * Gibt die aktuelle x-Position des Paddles zurück.
	 * @return Die aktuelle x-Position des Paddles.
	 */
	public static int getXPos(){
		return xPos;
	}
	
}
