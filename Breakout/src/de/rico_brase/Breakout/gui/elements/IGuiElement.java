package de.rico_brase.Breakout.gui.elements;

import java.awt.Graphics2D;

/**
 * Repräsentiert ein GUI-Element.
 * @author Rico Brase
 *
 */
public abstract class IGuiElement {

	public int xPos = 0;
	public int yPos = 0;
	public int width = 0;
	public int height = 0;
	
	public IGuiElement(){
		
	}
	
	public IGuiElement(int x, int y, int width, int height){
		super();
		this.setBounds(x, y, width, height);
	}
	
	public void setBounds(int x, int y, int width, int height){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void render(Graphics2D g);
	
	public abstract void onLeftClick();
	
	
	
	
}
