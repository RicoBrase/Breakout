package de.rico_brase.Breakout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import de.rico_brase.Breakout.map.Map;
import de.rico_brase.Breakout.map.MapRenderer;
import de.rico_brase.Breakout.player.Player;
import de.rico_brase.Breakout.powerup.PowerUps;
import de.rico_brase.Breakout.scenes.Scenes;
import de.rico_brase.Breakout.utils.Assets;

/**
 * Dies ist das Panel, auf welchem das Spiel und jeglicher sichtbarer Inhalt gezeichnet wird.
 * @author Rico Brase
 *
 */
public class Screen extends JPanel implements Runnable{

	private static final long serialVersionUID = -146713464426694906L;

	Thread th;
	int fps = 0;
	
	/**
	 * Aktuelle Szene.
	 */
	Scenes currentScene;
	
	public static Screen INSTANCE;
	
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	
	/**
	 * Unsichtbarer Cursor.
	 */
	private Cursor blankCursor;
	
	/**
	 * Debuginfos, die in der oberen linken Bildschirmecke dargestellt werden.
	 */
	public ArrayList<String> debugInfo;
	
	public Screen(){
		super();
		
		INSTANCE = this;
		currentScene = Scenes.MAIN_MENU;
		
		debugInfo = new ArrayList<String>();
		debugInfo.add("");
		
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blankCursor");
		
		th = new Thread(this);
		th.start();
	}
	
	/**
	 * Zeichnet den sichtbaren Inhalt des Spiels.
	 * @param g Das Graphics-Objekt des JPanels.
	 */
	@Override
	public void paintComponent(Graphics g){
		
		WIDTH = this.getWidth();
		HEIGHT = this.getHeight();
		
		Graphics2D g2 = (Graphics2D)g;
		
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		if(WIDTH != 0 && HEIGHT != 0){
			if(!currentScene.isInitialized()) currentScene.init(this);
			currentScene.renderScene(g2, this);
		}
		
		debugInfo.add("FPS: " + fps);
		if(currentScene == Scenes.GAME){
			debugInfo.add("Lives: " + Player.INSTANCE.lives);
			for(PowerUps pu : Player.INSTANCE.current_powerups){
				debugInfo.add(pu.toString());
			}
		}
		
		g.setColor(Color.BLACK);
		for(int i = 0; i < debugInfo.size(); i++){
			g.drawString(debugInfo.get(i), 10, 15 + (15* i));
		}
//		g.drawString("FPS: " + fps, 10, 15);
//		g.drawString("Angle: " + Rotation.getAngle(), 10, 30);
//		if(currentScene == Scenes.GAME) g.drawString("Lives: " + Player.INSTANCE.lives, 10, 45);
//		if(currentScene == Scenes.GAME) g.drawString("yPos: " + Ball.getYPos(), 10, 60);
		
		debugInfo.clear();
		
	}

	/**
	 * Der sog. Gameloop.
	 * Ein Durchlauf der while-Schleife pro Frame.
	 * Berechnung der FPS.
	 */
	@Override
	public void run() {
		
		long lastFrame = System.currentTimeMillis();
		int frames = 0;
		
		while(true){
			if(System.currentTimeMillis()-1000 >= lastFrame){
				this.fps = frames;
				lastFrame = System.currentTimeMillis();
				frames = 0;
			}
			frames++;
			try{
				/**
				 * Frame-Limiter.
				 * Warte 1ms pro GameLoop-Durchgang.
				 * --> Max. 1000 FPS
				 */
				Thread.sleep(1);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			repaint();
		}
	}
	
	public void changeScene(){
		if(currentScene == Scenes.MAIN_MENU){
			currentScene = Scenes.GAME;
		}else if(currentScene == Scenes.GAME){
			currentScene = Scenes.MAIN_MENU;
			Scenes.MAIN_MENU.getScene().onSceneLoaded();
			this.setCursor(Cursor.getDefaultCursor());
		}
	}
	
	public void setScene(Scenes scene){
		currentScene = scene;
		this.setCursor(Cursor.getDefaultCursor());
	}
	
	public void loadMainMenu(){
		currentScene = Scenes.MAIN_MENU;
		Scenes.MAIN_MENU.getScene().onSceneLoaded();
		this.setCursor(Cursor.getDefaultCursor());
	}
	
	public void newGame(Map map){
		//Map map = Assets.loadMapFromAssets(Assets.Game.Maps.TESTMAP);
		
		if(map == null){
			map = Assets.loadMapFromAssets(Assets.Game.Maps.TESTMAP);
		}
		
		if(map == null){
			return;
		}
		
		MapRenderer.setMap(map);
		currentScene = Scenes.GAME;
		
		Scenes.GAME.getScene().onSceneLoaded();
		
		this.setCursor(blankCursor);
		
	}
	
	public Scenes getCurrentScene(){
		return this.currentScene;
	}
	
	
}
