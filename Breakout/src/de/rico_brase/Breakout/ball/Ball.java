package de.rico_brase.Breakout.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.bar.Bar;

public class Ball {

	public static int width = 30;
	public static int height = 30;
	
	private static int xPos = 0;
	private static int yPos = 0;
	
	private static int speedMultiplier = 45;
	
	public static boolean stickToBar = true;
	
	public static void renderBall(Graphics2D g){
		//RenderManager.renderImageFromAssetsAt(Assets.Game.BAR, xPos-width/2, yPos, width, height, g);
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(xPos, yPos, width, height);
		g.setColor(new Color(0, 0, 0, 255));
		g.setStroke(new BasicStroke(2.0F));
		g.drawOval(xPos, yPos, width, height);
		g.setColor(c);
	}
	
	public static void setPos(int xPos, int yPos){
		Ball.xPos = xPos;
		Ball.yPos = yPos;
	}
	
	public static void move(){
		
	}
	
	public static void resetBall(){
		Ball.xPos = Screen.INSTANCE.getWidth()/2 - Ball.width/2;
		Ball.yPos = Screen.INSTANCE.getHeight() - Bar.height - height - 50;
		
		stickToBar = true;
	}
	
	public static int getYPos(){
		return yPos;
	}
	
	public static int getXPos(){
		return xPos;
	}
}
