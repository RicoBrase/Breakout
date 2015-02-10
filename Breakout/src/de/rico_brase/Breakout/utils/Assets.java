package de.rico_brase.Breakout.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Assets {

	
	public static Image getImageFromAssets(String loc){
		try{
			Image img = new ImageIcon(RenderManager.class.getResource(loc)).getImage();
			return img;
		}catch(Exception ex){
			System.err.println("Failed to load image: " + loc);
			//ex.printStackTrace();
		}
		return null;
	}
	
	
	public class MainMenu{
		
		public static final String LOGO = "/assets/images/main_menu/logo.png";
		
	}
	
	public class Game{
		
	}
	
	public class General{
		public static final String ICON_256 = "/assets/images/icon256.png";
		public static final String ICON_64 = "/assets/images/icon64.png";
	}
	
}
