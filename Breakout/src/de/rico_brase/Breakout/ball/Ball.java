package de.rico_brase.Breakout.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ballmovement.MovementUtils;
import de.rico_brase.Breakout.ballmovement.Rotation;
import de.rico_brase.Breakout.bar.Bar;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class Ball {

	public static int width = 30;
	public static int height = 30;
	
	private static int xPos = 0;
	private static int yPos = 0;
	
	private static int speedMultiplier = 4;
	
	public static boolean stickToBar = true;
	
	public static void renderBall(Graphics2D g){
		//RenderManager.renderImageFromAssetsAt(Assets.Game.BAR, xPos-width/2, yPos, width, height, g);
		//Color c = g.getColor();
		//g.setColor(Color.ORANGE);
		//g.fillOval(xPos, yPos, width, height);
		//g.setColor(new Color(0, 0, 0, 255));
		//g.setStroke(new BasicStroke(2.0F));
		//g.drawOval(xPos, yPos, width, height);
		//g.setColor(c);
		
		RenderManager.renderImageFromAssetsAt(Assets.Game.BALL, xPos, yPos, width, height, g);
	}
	
	public static void setPos(int xPos, int yPos){
		Ball.xPos = xPos;
		Ball.yPos = yPos;
	}
	
	public static void move(){
		double newX = MovementUtils.getVelocity(MovementUtils.getDirectionX(Rotation.getAngle()), speedMultiplier);
		double newY = MovementUtils.getVelocity(MovementUtils.getDirectionY(Rotation.getAngle()), speedMultiplier);
		
		if((xPos+(int)newX) <= 0 && (xPos+(int)newX) >= Screen.INSTANCE.getWidth()){
			
		}
		
		setPos(xPos+(int)newX, yPos+(int)newY);
		
	}
	
	public static void resetBall(){
		Ball.xPos = Screen.INSTANCE.getWidth()/2 - Ball.width/2;
		Ball.yPos = Screen.INSTANCE.getHeight() - Bar.height - height - 50;
		
		stickToBar = true;
	}
	
	public static void bounce(){
		boolean invertBonus = Rotation.rand.nextBoolean();
		int angleBonus = Rotation.rand.nextInt(90);
		if(invertBonus) angleBonus = -1 * angleBonus;
		
		Rotation.invert();
		Rotation.addAngle(angleBonus);
	}
	
	public static int getYPos(){
		return yPos;
	}
	
	public static int getXPos(){
		return xPos;
	}
	
}
