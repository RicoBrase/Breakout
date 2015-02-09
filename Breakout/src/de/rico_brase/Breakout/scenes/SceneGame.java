package de.rico_brase.Breakout.scenes;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;

public class SceneGame extends Scene{

	@Override
	public void renderScene(Graphics2D g, Screen s) {
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		
	}

	@Override
	public void init(Screen s) {
		
	}

	
	
}
