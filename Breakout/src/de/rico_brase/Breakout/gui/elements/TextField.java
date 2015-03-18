package de.rico_brase.Breakout.gui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.utils.RenderManager;

public abstract class TextField extends IGuiElement{

	private String text;
	
	public TextField(String text, int x, int y, int width, int height){
		this.text = text;
		this.setBounds(x, y, width, height);
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	/**
	 * Rendert das Textfeld.
	 * Hierbei wird das Aussehen des Textfeldes festgelegt.
	 * @param g
	 */
	public abstract void renderTextField(Graphics2D g);
	
	/**
	 * Rendert vordefinierte Eigenschaften des Textfeldes.
	 */
	public void render(Graphics2D g){
		renderTextField(g);
		
		Font orig_font = g.getFont();
		Font font = g.getFont();
		
		g.setColor(Color.BLACK);
		g.setFont(font.deriveFont(15F).deriveFont(Font.BOLD));
		
		RenderManager.drawStringCentered(text, this.width, this.height, this.xPos, this.yPos, (Graphics2D)g);
		g.setFont(orig_font);
	}

	@Override
	public abstract void onLeftClick();

}
