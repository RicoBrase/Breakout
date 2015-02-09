package de.rico_brase.Breakout.scenes.mainmenu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Frame;
import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.GameButton;
import de.rico_brase.Breakout.gui.elements.IGuiElement;
import de.rico_brase.Breakout.scenes.Scene;
import de.rico_brase.Breakout.utils.RenderManager;

public class SceneMainMenu extends Scene{
	
	public SceneMainMenu(){
		
	}
	
	public void init(Screen s){
		
		this.addElement(new GameButton("Spielen", Screen.WIDTH/4, 400, Screen.WIDTH/2, 100) {

			@Override
			public void renderButton(Graphics2D g) {				
				g.setColor(Color.RED);
				g.fillRect(this.xPos, this.yPos, this.width, this.height);
				g.setColor(new Color(0, 0, 0, 150));
				g.setStroke(new BasicStroke(4F));
				g.drawRect(this.xPos+2, this.yPos+2, this.width-4, this.height-4);
			}
			
			@Override
			public void onLeftClick(){
				Screen.INSTANCE.changeScene();
			}
			
		});
	
		this.addElement(new GameButton("Spiel beenden", Screen.WIDTH/4, 505, Screen.WIDTH/2, 100) {
			
			@Override
			public void renderButton(Graphics2D g) {
				
				g.setColor(Color.RED);
				g.fillRect(this.xPos, this.yPos, this.width, this.height);
				g.setColor(new Color(0, 0, 0, 150));
				g.setStroke(new BasicStroke(4F));
				g.drawRect(this.xPos+2, this.yPos+2, this.width-4, this.height-4);
			}
			
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
		
		Font orig_font = g.getFont();
		
		for(IGuiElement gE : guiElements){
			if(gE != null) gE.render(g);
		}
		
		
		g.setFont(new Font("Stencil", Font.PLAIN, 80));
		g.setColor(new Color(180, 0, 0));
		RenderManager.drawStringCentered("Breakout", s.getWidth(), 0, 200, (Graphics2D)g);
		
		g.setFont(new Font("Stencil", Font.PLAIN, 82));
		g.setColor(Color.RED);
		RenderManager.drawStringCentered("Breakout", s.getWidth(), 0, 201, (Graphics2D)g);
		
		g.setFont(orig_font);
	}

}
