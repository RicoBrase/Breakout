package de.rico_brase.Breakout.utils;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import de.rico_brase.Breakout.map.Map;
import de.rico_brase.Breakout.map.MapLoader;

/**
 * Der Asset-Manager des Spiels.
 * Mit Hilfe dieser Klasse können sämtliche Assets in Form von Bildern, Maps oder generelle Dateien geladen werden.
 * 
 * @author Rico Brase
 *
 */
public class Assets {

	/**
	 * Diese Methode lädt Bilder aus den Assets.
	 * @param loc Das zu ladende Asset.
	 * @return Das geladene Bild.
	 */
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
	
	/**
	 * Diese Methode lädt Maps aus den Assets.
	 * @param loc Die zu ladende Map.
	 * @return Die geladene Map.
	 */
	public static Map loadMapFromAssets(String loc){
		try{
			return MapLoader.loadMapFromFile(new File(MapLoader.class.getResource(loc).getFile()));
		}catch(Exception ex){
			System.err.println("[Error] Failed to load map: " + loc);
			//ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Lädt eine generelle Datei aus den Assets.
	 * @param loc Die ladende Datei.
	 * @return Die geladene Datei.
	 */
	public static File getFileFromAssets(String loc){
		return new File(MapLoader.class.getResource(loc).getFile());
	}
	
	/**
	 * Die Assets des Hauptmenüs.
	 * @author Rico Brase
	 *
	 */
	public class MainMenu{
		
		public static final String LOGO = "/assets/images/main_menu/logo.png";
		
		public static final String GOTY = "/assets/images/main_menu/goty.png";
		public static final String TENOFTEN = "/assets/images/main_menu/tenoften.png";
		
	}
	
	/**
	 * Die Assets des Spiels.
	 * @author Rico Brase
	 *
	 */
	public class Game{
		
		public static final String BAR = "/assets/images/game/bar_complete.png";
		
		public static final String BALL = "/assets/images/game/ball.png";
		public static final String BALL_FLAME = "/assets/images/game/ball_flame.png";
		
		/**
		 * Die Assets der PowerUps.
		 * @author Rico Brase
		 *
		 */
		public class Powerups{
			public static final String FLAME_UP = "/assets/images/game/powerups/flame.png";
			public static final String HEALTH_UP = "/assets/images/game/powerups/health.png";
			public static final String PADDLE_UP = "/assets/images/game/powerups/paddle.png";
		}
		
		/**
		 * Die Assets der Maps.
		 * @author Rico Brase
		 *
		 */
		public class Maps{
			public static final String TESTMAP = "/assets/maps/testmap.bomap";
		}
		
	}
	
	/**
	 * Die Assets der Schlussszene ("Win"-/"Lost"-Szene).
	 * @author Rico Brase
	 *
	 */
	public class End{
		public static final String DAN = "/assets/images/end/dansgaming_sketch.png";
		public static final String WAFFLE = "/assets/images/end/waffle_facepalm.png";
	}
	
	/**
	 * Generelle Assets.
	 * @author Rico Brase
	 *
	 */
	public class General{
		public static final String ICON_256 = "/assets/images/icon256.png";
		public static final String ICON_64 = "/assets/images/icon64.png";
	}
	
}
