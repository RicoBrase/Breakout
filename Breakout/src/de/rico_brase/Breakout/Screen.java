package de.rico_brase.Breakout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import de.rico_brase.Breakout.bar.Bar;
import de.rico_brase.Breakout.map.Map;
import de.rico_brase.Breakout.map.MapLoader;
import de.rico_brase.Breakout.map.MapRenderer;
import de.rico_brase.Breakout.scenes.Scenes;
import de.rico_brase.Breakout.utils.Assets;

public class Screen extends JPanel implements Runnable{

	private static final long serialVersionUID = -146713464426694906L;

	Thread th;
	int fps = 0;
	
	Scenes currentScene;
	
	public static Screen INSTANCE;
	
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	
	private Cursor blankCursor;
	
	public Screen(){
		super();
		
		INSTANCE = this;
		currentScene = Scenes.MAIN_MENU;
		
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blankCursor");
		
		th = new Thread(this);
		th.start();
	}
	
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
		
		
		g.setColor(Color.BLACK);
		g.drawString("FPS: " + fps, 10, 15);
		
	}

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
			this.setCursor(Cursor.getDefaultCursor());
		}
	}
	
	public void newGame(){
		Map map = Assets.loadMapFromAssets(Assets.Game.Maps.TESTMAP);
		
		if(map == null){
			return;
		}
		
		Bar.reset = true;
		
		MapRenderer.setMap(map);
		currentScene = Scenes.GAME;
		
		this.setCursor(blankCursor);
	}
	
	public Scenes getCurrentScene(){
		return this.currentScene;
	}
	
	
}
