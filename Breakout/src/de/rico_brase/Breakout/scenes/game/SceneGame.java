package de.rico_brase.Breakout.scenes.game;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.bar.Bar;
import de.rico_brase.Breakout.map.Map;
import de.rico_brase.Breakout.map.MapRenderer;
import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.map.blocks.Blocks;
import de.rico_brase.Breakout.scenes.Scene;

public class SceneGame extends Scene{

	public static SceneGame INSTANCE;
	
	public static int blockWidth = 0;
	public static int blockHeight = 0;
	
	public static final Color BACKGROUND_COLOR = Color.GRAY;
	
	public SceneGame(){
		INSTANCE = this;
	}
	
	@Override
	public void init(Screen s) {
		blockWidth = (int)(s.getWidth() * Blocks.WIDTH_MULT);
		blockHeight = (int)(s.getHeight() * Blocks.HEIGHT_MULT);
	}

	@Override
	public void renderScene(Graphics2D g, Screen s) {
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		
		MapRenderer.renderMap(g);
		
		Bar.renderBar(g);
		
	}
	
	@Override
	public void handleLeftMouseClick(int xPos, int yPos){
		Map map = MapRenderer.getLoadedMap();
		Block block = map.getBlockAt(xPos, yPos);
		if(block != null){
			map.setBlockAt(xPos, yPos, block.breakBlock());
		}
	}
	
}
