package de.rico_brase.Breakout.scenes.info;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.net.URI;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.IGuiElement;
import de.rico_brase.Breakout.gui.elements.buttons.MainMenuButton;
import de.rico_brase.Breakout.scenes.Scene;
import de.rico_brase.Breakout.scenes.Scenes;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Die Informationsszene. Hier werden Informationen zu dem Spiel angezeigt.
 * Für weitere Informationen, die nicht in das Spiel hinein programmiert wurden, steht eine README.txt zur Verfügung.
 * Diese enthält neben einer Spielanleitung auch weitere Hinweise.
 * 
 * @author Rico Brase
 *
 */
public class SceneInfo extends Scene{

	@Override
	public void init(Screen s) {
		
		this.addElement(new IGuiElement(20, 20, s.getWidth()-40, Screen.HEIGHT-270) {
			
			@Override
			public void render(Graphics2D g) {
				g.setColor(new Color(170, 200, 0));
				g.fillRect(this.xPos, this.yPos, this.width, this.height);
				g.setColor(new Color(0, 0, 0, 150));
				g.setStroke(new BasicStroke(4F));
				g.drawRect(this.xPos+2, this.yPos+2, this.width-4, this.height-4);
				
				Font orig_font = g.getFont();
				g.setColor(Color.BLACK);
				g.setFont(g.getFont().deriveFont(24F).deriveFont(Font.BOLD));
				RenderManager.drawStringCentered("Programmiert von: Rico Brase", this.width, 20, 100, g);
				
				
				g.setFont(orig_font);
			}
			
			@Override
			public void onLeftClick() {
				
			}
		});
		
		this.addElement(new MainMenuButton("Öffne Readme.txt", Screen.WIDTH/4, Screen.HEIGHT-230, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick(){
				if(Desktop.isDesktopSupported()){
					try {
						Desktop.getDesktop().browse(URI.create(SceneInfo.class.getResource("/README.txt").getFile().substring(1)));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		});
		
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
