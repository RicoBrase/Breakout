package de.rico_brase.Breakout.bar;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class Bar {

	private static int width = 500;
	private static final int height = 25;
	
	private static int xPos = 0;
	private static int yPos = 0;
	
	private static int moveMultiplier = 45;
	
	public static boolean reset = true;
	
	public static void renderBar(Graphics2D g){
		
		if(reset){
			xPos = Screen.INSTANCE.getWidth()/2 - width/2;
			reset = false;
		}
		
		yPos = Screen.INSTANCE.getHeight() - height - 50;
		
		
		
		RenderManager.renderImageFromAssetsAt(Assets.Game.BAR, xPos, yPos, width, height, g);
	}
	
	public static void setXPos(int xPos){
		//Bar.xPos = xPos;
		
		if(xPos > Bar.xPos){
			Bar.xPos = Bar.xPos + (xPos-Bar.xPos);
		}else if(xPos < Bar.xPos){
			Bar.xPos = Bar.xPos - (Bar.xPos - xPos);
		}else{
			
		}
	}
	
	public static void moveLeft(){
		if(xPos >= moveMultiplier){
			xPos -= moveMultiplier;
		}
	}
	
	public static void moveRight(){
		if(xPos <= Screen.INSTANCE.getWidth() - moveMultiplier){
			xPos += moveMultiplier;
		}
	}
	
	
	
}
