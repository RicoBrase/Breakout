package de.rico_brase.Breakout.gui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.utils.RenderManager;

public abstract class GameButton extends IGuiElement{
	
	private String text = "";
	
	public GameButton(String text, int x, int y, int width, int height){
		this.text = text;
		setBounds(x, y, width, height);
	}
	
	public abstract void renderButton(Graphics2D g);
	
	public void render(Graphics2D g){
		renderButton(g);
		
		Font orig_font = g.getFont();
		Font font = g.getFont();
		
		g.setColor(Color.BLACK);
		g.setFont(font.deriveFont(15F).deriveFont(Font.BOLD));
		
		RenderManager.drawStringCentered(text, this.width, this.height, this.xPos, this.yPos, (Graphics2D)g);
		g.setFont(orig_font);
	}
	
	public abstract void onLeftClick();
	
}
