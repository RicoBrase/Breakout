package de.rico_brase.Breakout.scenes.info;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.IGuiElement;
import de.rico_brase.Breakout.gui.elements.buttons.MainMenuButton;
import de.rico_brase.Breakout.scenes.Scene;
import de.rico_brase.Breakout.scenes.Scenes;

public class SceneInfo extends Scene{

	@Override
	public void init(Screen s) {
		
		this.addElement(new MainMenuButton("Zurück zum Menü", Screen.WIDTH/4, Screen.HEIGHT-120, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick(){
				Screen.INSTANCE.setScene(Scenes.MAIN_MENU);
			}
			
		});
		
	}

	@Override
	public void renderScene(Graphics2D g, Screen s) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, Screen.WIDTH, Screen.HEIGHT);
		
		for(IGuiElement gE : guiElements){
			gE.render(g);
		}
		
	}

	@Override
	public void onSceneLoaded() {
		
	}

}
