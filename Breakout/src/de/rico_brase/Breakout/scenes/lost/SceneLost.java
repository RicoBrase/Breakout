package de.rico_brase.Breakout.scenes.lost;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.config.Config;
import de.rico_brase.Breakout.gui.elements.IGuiElement;
import de.rico_brase.Breakout.gui.elements.buttons.MainMenuButton;
import de.rico_brase.Breakout.player.Player;
import de.rico_brase.Breakout.scenes.Scene;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Die "Verloren"-Szene.
 * Diese wird angezeigt, sollten die Leben des Spielers auf 0 sinken.
 * 
 * TODO Den Schriftzug "Verloren" durch eine Grafik (siehe Hauptmenü) ersetzen.
 * 
 * @author Rico Brase
 *
 */
public class SceneLost extends Scene{

	public SceneLost(){
		
	}
	
	public void init(Screen s){
		
		this.addElement(new MainMenuButton("Zurück zum Menü", Screen.WIDTH/4, 400, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick(){
				Screen.INSTANCE.loadMainMenu();
				new Player();
			}
			
		});
	}
	
	@Override
	public void renderScene(Graphics2D g, Screen s) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, s.getWidth(), s.getHeight());		
		
		for(IGuiElement gE : guiElements){
			if(gE != null) gE.render(g);
		}
		
		Font orig_font = g.getFont();
		
		g.setColor(Color.RED);
		g.setFont(new Font("Stencil", Font.PLAIN, 92));
		RenderManager.drawStringCentered("VERLOREN", Screen.WIDTH, 200, 100, g);
		
		if(Config.getBoolean(Config.KEY_SPECIAL_IMGS)){
			RenderManager.renderImageFromAssetsAt(Assets.End.WAFFLE, Screen.WIDTH/4 , 400, -100, 100, g);
			RenderManager.renderImageFromAssetsAt(Assets.End.WAFFLE, Screen.WIDTH - (Screen.WIDTH/4), 400, 100, 100, g);
		}
		
		g.setFont(orig_font);
	}

	@Override
	public void onSceneLoaded() {
		
	}

}
