package de.rico_brase.Breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import de.rico_brase.Breakout.scenes.Scenes;

public class Screen extends JPanel implements Runnable{

	private static final long serialVersionUID = -146713464426694906L;

	Thread th;
	int fps = 0;
	
	Scenes currentScene;
	
	public static Screen INSTANCE;
	
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	
	public Screen(){
		super();
		
		INSTANCE = this;
		currentScene = Scenes.MAIN_MENU;
		
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
		}
	}
	
	public Scenes getCurrentScene(){
		return this.currentScene;
	}
	
	
}
