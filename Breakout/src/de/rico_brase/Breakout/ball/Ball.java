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
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class Ball {

	public static int width = 30;
	public static int height = 30;
	
	private static int xPos = 0;
	private static int yPos = 0;
	
	private static double newX = 0;
	private static double newY = 0;
	
	private static int speedMultiplier = 5;
	
	public static boolean stickToBar = true;
	
	public static int imgAngle = 0;
	public static int animSpeed = 5;
	
	public static void renderBall(Graphics2D g){
		//RenderManager.renderImageFromAssetsAt(Assets.Game.BAR, xPos-width/2, yPos, width, height, g);
		//Color c = g.getColor();
		//g.setColor(Color.ORANGE);
		//g.fillOval(xPos, yPos, width, height);
		//g.setColor(new Color(0, 0, 0, 255));
		//g.setStroke(new BasicStroke(2.0F));
		//g.drawOval(xPos, yPos, width, height);
		//g.setColor(c);
		
		RenderManager.renderImageFromAssetsWithRotationAt(Assets.Game.BALL, xPos, yPos, width, height, imgAngle, g);
	}
	
	public static void setPos(int xPos, int yPos){
		Ball.xPos = xPos;
		Ball.yPos = yPos;
	}
	
	private static void calculateNewPosition(){
		newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
		newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
	}
	
	public static void move(){
		
		imgAngle += animSpeed;
		
		newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
		newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		
		//LEFT
		if((xPos+ new Double(newX).intValue()) <= 0){
			bounce(Wall.LEFT);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		//RIGHT
		if((xPos+new Double(newX).intValue()) >= Screen.INSTANCE.getWidth()-Ball.width){
			bounce(Wall.RIGHT);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		//TOP
		if((yPos+ new Double(newY).intValue()) <= 0){
			bounce(Wall.TOP);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		//BOTTOM
		if((yPos+new Double(newY).intValue()) >= Screen.INSTANCE.getHeight()-Ball.height){
			System.out.println("[Debug] Lost!");
			resetBall();
		}
		
		//PADDLE
		if((yPos+new Double(newY).intValue()) >= Paddle.getYPos()-Paddle.height/2-Ball.height/2){
			if((xPos+ new Double(newX).intValue()) >= Paddle.getXPos()-Paddle.width/2 && (xPos+ new Double(newX).intValue()) <= Paddle.getXPos() + Paddle.width/2){
				bounce(Wall.PADDLE);
				newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
				newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
			}
			
		}
		
		Block block = MapRenderer.getLoadedMap().getBlockAt((xPos+ new Double(newX).intValue()), (yPos+new Double(newY).intValue()));
		
		//Touches a block
		if(block != null && block.getBlockType() != Blocks.EMPTY){
			MapRenderer.getLoadedMap().breakBlock((xPos+ new Double(newX).intValue()), (yPos+new Double(newY).intValue()));
			bounce(null);
			newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
			newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		}
		
		setPos(xPos+(int)newX, yPos+(int)newY);
		
	}
	
	public static void resetBall(){
		Ball.xPos = Paddle.getXPos() - Ball.width/2;
		Ball.yPos = Screen.INSTANCE.getHeight() - Paddle.height - height - 50;
		
		Rotation.setAngle(Directions.UP.getAngle());
		
		stickToBar = true;
	}
	
	public static void bounce(Wall wall){
		int angleBonus = Rotation.rand.nextInt(45);
		
		if(wall == Wall.LEFT){
			if(Rotation.getAngle() <= Directions.LEFT.getAngle() && Rotation.getAngle() > Directions.DOWN.getAngle()){
				if(Rotation.getAngle() == Directions.LEFT.getAngle()){
					if(angleBonus < 10) angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 10;
				}
				
				
				
				Rotation.setAngle(Directions.RIGHT.getAngle() + angleBonus);
				return;
			}
			if(Rotation.getAngle() > Directions.LEFT.getAngle() && Rotation.getAngle() < Directions.UP.getAngle()){
				Rotation.setAngle(Directions.RIGHT.getAngle() - angleBonus);
				return;
			}
		}
		
		if(wall == Wall.RIGHT){
			if(Rotation.getAngle() <= Directions.RIGHT.getAngle() + (Rotation.getAngle() > 0 ? 360 : 0) && Rotation.getAngle() > Directions.UP.getAngle()){
				if(Rotation.getAngle() == Directions.RIGHT.getAngle()){
					if(angleBonus < 10) angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 10;
				}
				Rotation.setAngle(Directions.LEFT.getAngle() + angleBonus);
				return;
			}
			if(Rotation.getAngle() > Directions.RIGHT.getAngle() && Rotation.getAngle() < Directions.DOWN.getAngle()){
				Rotation.setAngle(Directions.LEFT.getAngle() - angleBonus);
				return;
			}
		}
		
		if(wall == Wall.TOP){
			if(Rotation.getAngle() <= Directions.UP.getAngle() && Rotation.getAngle() > Directions.LEFT.getAngle()){
				if(Rotation.getAngle() == Directions.UP.getAngle()){
					if(angleBonus < 10) angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 10;
				}
				Rotation.setAngle(Directions.DOWN.getAngle() + angleBonus);
				return;
			}
			if(Rotation.getAngle() > Directions.UP.getAngle() && Rotation.getAngle() < Directions.RIGHT.getAngle() + 360){
				Rotation.setAngle(Directions.DOWN.getAngle() - angleBonus);
				return;
			}
			
//			Rotation.invert();
//			Rotation.addAngle(angleBonus);
		}
		
		if(wall == Wall.PADDLE){
			if(Rotation.getAngle() <= Directions.DOWN.getAngle() && Rotation.getAngle() > Directions.RIGHT.getAngle()){
				
				Rotation.setAngle((Directions.RIGHT.getAngle() + 360) - (Rotation.getAngle()));
				return;
			}
			if(Rotation.getAngle() > Directions.DOWN.getAngle() && Rotation.getAngle() < Directions.LEFT.getAngle() + 360){
				Rotation.setAngle(Directions.LEFT.getAngle() + (Directions.LEFT.getAngle()-Rotation.getAngle()));
				return;
			}
		}
		
		if(wall == null){
			if(Rotation.getAngle() <= Directions.DOWN.getAngle() && Rotation.getAngle() > Directions.RIGHT.getAngle()){
				
				Rotation.setAngle((Directions.RIGHT.getAngle() + 360) - (Rotation.getAngle()));
				return;
			}
			if(Rotation.getAngle() > Directions.DOWN.getAngle() && Rotation.getAngle() < Directions.LEFT.getAngle() + 360){
				Rotation.setAngle(Directions.LEFT.getAngle() + (Directions.LEFT.getAngle()-Rotation.getAngle()));
				return;
			}
			if(Rotation.getAngle() <= Directions.UP.getAngle() && Rotation.getAngle() > Directions.LEFT.getAngle()){
				if(Rotation.getAngle() == Directions.UP.getAngle()){
					if(angleBonus < 10) angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 10;
				}
				Rotation.setAngle(Directions.DOWN.getAngle() + angleBonus);
				return;
			}
			if(Rotation.getAngle() > Directions.UP.getAngle() && Rotation.getAngle() < Directions.RIGHT.getAngle() + 360){
				Rotation.setAngle(Directions.DOWN.getAngle() - angleBonus);
				return;
			}
			if(Rotation.getAngle() <= Directions.RIGHT.getAngle() + (Rotation.getAngle() > 0 ? 360 : 0) && Rotation.getAngle() > Directions.UP.getAngle()){
				if(Rotation.getAngle() == Directions.RIGHT.getAngle()){
					if(angleBonus < 10) angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 10;
				}
				Rotation.setAngle(Directions.LEFT.getAngle() + angleBonus);
				return;
			}
			if(Rotation.getAngle() > Directions.RIGHT.getAngle() && Rotation.getAngle() < Directions.DOWN.getAngle()){
				Rotation.setAngle(Directions.LEFT.getAngle() - angleBonus);
				return;
			}
			if(Rotation.getAngle() <= Directions.LEFT.getAngle() && Rotation.getAngle() > Directions.DOWN.getAngle()){
				if(Rotation.getAngle() == Directions.LEFT.getAngle()){
					if(angleBonus < 10) angleBonus = (Rotation.rand.nextBoolean() ? 1 : -1) * 10;
				}
				
				Rotation.setAngle(Directions.RIGHT.getAngle() + angleBonus);
				return;
			}
			if(Rotation.getAngle() > Directions.LEFT.getAngle() && Rotation.getAngle() < Directions.UP.getAngle()){
				Rotation.setAngle(Directions.RIGHT.getAngle() - angleBonus);
				return;
			}
			
			//Rotation.invert();
			return;
		}
		
	}
	
	public static int getYPos(){
		return yPos;
	}
	
	public static int getXPos(){
		return xPos;
	}
	
	public static boolean touchesWall(Wall wall){
		
		if(wall == Wall.TOP){
			if(yPos <= -Ball.height/2){
				return true;
			}
			
			
		}
		
		return false;
	}
	
}
