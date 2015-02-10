package de.rico_brase.Breakout.scenes.mainmenu;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.IGuiElement;
import de.rico_brase.Breakout.gui.elements.buttons.MainMenuButton;
import de.rico_brase.Breakout.scenes.Scene;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class SceneMainMenu extends Scene{
	
	public SceneMainMenu(){
		
	}
	
	public void init(Screen s){
		
		this.addElement(new MainMenuButton("Spielen", Screen.WIDTH/4, 400, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick(){
				Screen.INSTANCE.changeScene();
			}
			
		});
	
		this.addElement(new MainMenuButton("Spiel beenden", Screen.WIDTH/4, 505, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick(){
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void renderScene(Graphics2D g, Screen s) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		
		//Font orig_font = g.getFont();
		
		for(IGuiElement gE : guiElements){
			if(gE != null) gE.render(g);
		}
		
		
		RenderManager.renderImageFromAssetsAt(Assets.MainMenu.LOGO, s.getWidth()/4, 0, s.getWidth()/2, s.getHeight()/2, g);
		
		
		//g.setFont(orig_font);
	}

}
