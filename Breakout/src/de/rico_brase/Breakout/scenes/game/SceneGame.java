package de.rico_brase.Breakout.scenes.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Robot;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ball.Ball;
import de.rico_brase.Breakout.map.Map;
import de.rico_brase.Breakout.map.MapRenderer;
import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.map.blocks.Blocks;
import de.rico_brase.Breakout.paddle.Paddle;
import de.rico_brase.Breakout.player.Player;
import de.rico_brase.Breakout.scenes.Scene;

public class SceneGame extends Scene{

	public static SceneGame INSTANCE;
	
	public static int blockWidth = 0;
	public static int blockHeight = 0;
	
	public static final Color BACKGROUND_COLOR = Color.GRAY;
	
	private boolean paused = false;
	
	public SceneGame(){
		INSTANCE = this;
		new Player();
	}
	
	@Override
	public void init(Screen s) {
		blockWidth = (int)(s.getWidth() * Blocks.WIDTH_MULT);
		blockHeight = (int)(s.getHeight() * Blocks.HEIGHT_MULT);
		
		try{
			Robot r = new Robot();
			r.mouseMove(s.getWidth()/2, s.getHeight()/2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		Paddle.reset = true;
	}

	@Override
	public void renderScene(Graphics2D g, Screen s) {
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		
		MapRenderer.renderMap(g);
		
		Paddle.renderBar(g);
		
		if(!Ball.stickToBar && !paused){
			Ball.move();
		}
		
		Ball.renderBall(g);
		
	}
	
	@Override
	public void handleLeftMouseClick(int xPos, int yPos){
//		Map map = MapRenderer.getLoadedMap();
//		Block block = map.getBlockAt(xPos, yPos);
//		if(block != null){
//			map.setBlockAt(xPos, yPos, block.breakBlock());
//		}
	}

	@Override
	public void onSceneLoaded() {
		Paddle.reset = true;
		Ball.resetBall();
	}
	
	public boolean isPaused(){
		return this.paused;
	}
	
	public void pause(){
		this.paused = true;
	}
	
	public void resume(){
		this.paused = false;
	}
	
}
