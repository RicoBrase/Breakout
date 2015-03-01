package de.rico_brase.Breakout.utils;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import de.rico_brase.Breakout.map.Map;
import de.rico_brase.Breakout.map.MapLoader;

public class Assets {

	
	public static Image getImageFromAssets(String loc){
		try{
			Image img = new ImageIcon(RenderManager.class.getResource(loc)).getImage();
			return img;
		}catch(Exception ex){
			System.err.println("[Error] Failed to load image: " + loc);
			//ex.printStackTrace();
		}
		return null;
	}
	
	public static Map loadMapFromAssets(String loc){
		try{
			return MapLoader.loadMapFromFile(new File(MapLoader.class.getResource(loc).getFile()));
		}catch(Exception ex){
			System.err.println("[Error] Failed to load map: " + loc);
			//ex.printStackTrace();
		}
		return null;
	}
	
	public class MainMenu{
		
		public static final String LOGO = "/assets/images/main_menu/logo.png";
		
		public static final String GOTY = "/assets/images/main_menu/goty.png";
		public static final String TENOFTEN = "/assets/images/main_menu/tenoften.png";
		
	}
	
	public class Game{
		
		public static final String BAR = "/assets/images/game/bar_complete.png";
		public static final String BALL = "/assets/images/game/ball.png";
		
		public class Maps{
			public static final String TESTMAP = "/assets/maps/testmap.bomap";
		}
		
	}
	
	public class End{
		public static final String DAN = "/assets/images/end/dansgaming_sketch.png";
		public static final String WAFFLE = "/assets/images/end/waffle_facepalm.png";
	}
	
	public class General{
		public static final String ICON_256 = "/assets/images/icon256.png";
		public static final String ICON_64 = "/assets/images/icon64.png";
	}
	
}
