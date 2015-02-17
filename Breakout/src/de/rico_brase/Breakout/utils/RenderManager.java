package de.rico_brase.Breakout.utils;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class RenderManager {
	
	public static RenderManager INSTANCE = new RenderManager();
	private static AffineTransform identity = new AffineTransform();
	
	public static void drawStringCentered(String s, int width, int height, int YPos, Graphics2D g2d){
        drawStringCentered(s, width, height, 0, YPos, g2d);
	}
	
	public static void drawStringCentered(String s, int width, int height, int XPos, int YPos, Graphics2D g2d){
        int stringLen = (int) g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int stringHeight = (int) g2d.getFontMetrics().getStringBounds(s, g2d).getHeight();
        int startW = width/2 - stringLen/2;
        int startH = height/2 - stringHeight/2;
        g2d.drawString(s, startW + XPos, (height > 0 ? YPos - startH + height : YPos));
	}
	
	public static void renderImageFromAssetsAt(String loc, int xPos, int yPos, int width, int height, Graphics2D g){
		g.drawImage(Assets.getImageFromAssets(loc), xPos, yPos, width, height, null);
	}
	
	public static void renderImageFromAssetsWithRotationAt(String loc, int xPos, int yPos, int width, int height, int angle, Graphics2D g){
		
		AffineTransform trans = new AffineTransform();
		trans.setTransform(identity);
		//trans.scale(1, 1);
		trans.translate(+(xPos+width/2), +(yPos+height/2));
		trans.rotate(Math.toRadians(angle));
		trans.translate(-(xPos+width/2), -(yPos+height/2));
		
		//g.drawImage(Assets.getImageFromAssets(loc), trans, null);
		AffineTransform old_trans = g.getTransform();
		g.setTransform(trans);
		g.drawImage(Assets.getImageFromAssets(loc), xPos, yPos, width, height, null);
		g.setTransform(old_trans);
		//trans.rotate(Math.toRadians(-angle));
	}
	
}
