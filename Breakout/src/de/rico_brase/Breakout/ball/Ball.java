package de.rico_brase.Breakout.ball;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ballmovement.Directions;
import de.rico_brase.Breakout.ballmovement.MovementUtils;
import de.rico_brase.Breakout.ballmovement.Rotation;
import de.rico_brase.Breakout.map.MapRenderer;
import de.rico_brase.Breakout.map.Wall;
import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.map.blocks.Blocks;
import de.rico_brase.Breakout.paddle.Paddle;
import de.rico_brase.Breakout.player.Player;
import de.rico_brase.Breakout.powerup.PowerUps;
import de.rico_brase.Breakout.scenes.Scenes;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Diese Klasse enth�lt alle Methoden, die f�r den Ball wichtig sind.
 * Rotationen werden in der Klasse {@link de.rico_brase.Breakout.ballmovement.Rotation Rotation} behandelt
 * @author Rico Brase
 *
 */
public class Ball {

	public static int width = 30;
	public static int height = 30;
	
	private static int xPos = 0;
	private static int yPos = 0;
	
	private static double newX = 0;
	private static double newY = 0;
	
	private static int speedMultiplier = 5;
	
	public static boolean stickToBar = true;
	
	/**
	 * Die Rotation des Balls (Bild).
	 */
	public static int imgAngle = 0;
	/**
	 * Die Rotationsgeschwindigkeit des Balls.
	 */
	public static int animSpeed = 5;
	
	/**
	 * Diese Methode zeichnet den Ball auf das Panel.
	 * @param g Das Graphics-Objekt der {@link de.rico_brase.Breakout.Screen Screen}-Klasse.
	 */
	public static void renderBall(Graphics2D g){
		
		String imgloc = (Player.INSTANCE.current_powerups.contains(PowerUps.FLAME) ? Assets.Game.BALL_FLAME : Assets.Game.BALL);
		
		RenderManager.renderImageFromAssetsWithRotationAt(imgloc, xPos, yPos, width, height, imgAngle, g);
	}
	
	
	public static void setPos(int xPos, int yPos){
		Ball.xPos = xPos;
		Ball.yPos = yPos;
	}
	
	/**
	 * Diese Methode bewegt den Ball anhand seiner Rotation und �berpr�ft, ob der Ball einen Block, eine Wand oder das Paddle ber�hrt.
	 */
	public static void move(){
		
		imgAngle += animSpeed;
		
		newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
		newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		
		//LEFT-WALL
		if((xPos+ new Double(newX).intValue()) <= 0){
			bounce(Wall.LEFT);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		//RIGHT-WALL
		if((xPos+new Double(newX).intValue()) >= Screen.INSTANCE.getWidth()-Ball.width){
			bounce(Wall.RIGHT);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		//TOP-WALL
		if((yPos+ new Double(newY).intValue()) <= 0){
			bounce(Wall.TOP);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		//BOTTOM-WALL
		if((yPos+new Double(newY).intValue()) >= Screen.INSTANCE.getHeight()-Ball.height){
			//System.out.println("[Debug] Lost!");
			Player.INSTANCE.die();
			resetBall();
			if(!Player.INSTANCE.isAlive()) Screen.INSTANCE.setScene(Scenes.LOST);
		}
		
		//PADDLE
		if((yPos+new Double(newY).intValue()) >= Paddle.getYPos()-Paddle.height/2-Ball.height/2){
			if((xPos+ new Double(newX).intValue()) + (Ball.width) >= Paddle.getXPos()-Paddle.width/2 && (xPos+ new Double(newX).intValue()) <= Paddle.getXPos() + Paddle.width/2){
				bounce(Wall.PADDLE);
				newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
				newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
			}
			
		}
		
		Block block = MapRenderer.getLoadedMap().getBlockAt((xPos+ new Double(newX).intValue()/* + (Ball.width/2)*/), (yPos+new Double(newY).intValue() /*+ (Ball.height/2)*/));
		
		//Touches a block
		if(block != null && block.getBlockType() != Blocks.EMPTY){
			MapRenderer.getLoadedMap().breakBlock((xPos+ new Double(newX).intValue()), (yPos+new Double(newY).intValue()));
			if(!Player.INSTANCE.current_powerups.contains(PowerUps.FLAME)) bounce(null);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		setPos(xPos+(int)newX, yPos+(int)newY);
		
	}
	
	/**
	 * Setze die Ball-Position auf die Mitte des Paddles und setzte die Rotation nach oben.
	 */
	public static void resetBall(){
		Ball.xPos = Paddle.getXPos() - Ball.width/2;
		Ball.yPos = Screen.INSTANCE.getHeight() - Paddle.height - height - 50 - (Player.INSTANCE.lives == 3 ? 0 : speedMultiplier);
		
		stickToBar = true;
		
		Rotation.setAngle(Directions.UP.getAngle());
	}
	
	/**
	 * Berechnet den Abprallwinkel des Balls.
	 * @param wall Die Wand, von der der Ball abprallt. Siehe {@link de.rico_brase.Breakout.map.Wall}
	 */
	public static void bounce(Wall wall){
		int angleBonus = Rotation.rand.nextInt(25);
		
		while(angleBonus < 15 && angleBonus > -15){
			angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 15;
		}
		
		if(wall == Wall.LEFT){
			Rotation.setAngle(Rotation.mirrorAngle(Rotation.getAngle(), Directions.RIGHT));
		}
		
		if(wall == Wall.RIGHT){
			Rotation.setAngle(Rotation.mirrorAngle(Rotation.getAngle(), Directions.LEFT));
		}
		
		if(wall == Wall.TOP){
			Rotation.setAngle(Rotation.mirrorAngle(Rotation.getAngle(), Directions.DOWN));
		}
		
		if(wall == Wall.PADDLE){
			
			double paddleSegmentWidth = (Paddle.width/2D) / 45D;
			
			if(Rotation.getAngle() == Directions.DOWN.getAngle()){
				if(Ball.xPos < Paddle.getXPos()){
					for(int i = 0; i < (int)(Paddle.width/paddleSegmentWidth); i++){
						if((i * paddleSegmentWidth) > (Paddle.getXPos() - Ball.xPos)){
							Rotation.setAngle(Directions.UP.getAngle() + (int)(i*paddleSegmentWidth));
							//System.out.println("i: " + i + " | paddleSegmentWidth: " + paddleSegmentWidth + " | i*paddleSegmentWidth: " + i*paddleSegmentWidth);
						}
					}
				}
				
				if(Ball.xPos > Paddle.getXPos()){
					for(int i = 0; i < (int)(Paddle.width/paddleSegmentWidth); i++){
						if((i * paddleSegmentWidth) < (Ball.xPos - Paddle.getXPos())){
							Rotation.setAngle(Rotation.mirrorAngle(Rotation.getAngle(), Directions.UP) + (int)(i*paddleSegmentWidth));
							//System.out.println("i: " + i + " | paddleSegmentWidth: " + paddleSegmentWidth + " | i*paddleSegmentWidth: " + i*paddleSegmentWidth);
						}
					}
				}
			}else{
				Rotation.setAngle(Rotation.mirrorAngle(Rotation.getAngle(), Directions.UP));
			}
		}
		
		if(wall == null){
			
			Directions.getDirectionByAngle(Rotation.getAngle());
			Rotation.setAngle(Rotation.mirrorAngle(Rotation.getAngle(), Directions.UP));
			
			return;
		}
		
	}
	
	/**
	 * @return Die y-Position des Balls.
	 */
	public static int getYPos(){
		return yPos;
	}
	
	/**
	 * 
	 * @return Die x-Position des Balls.
	 */
	public static int getXPos(){
		return xPos;
	}
	
}
