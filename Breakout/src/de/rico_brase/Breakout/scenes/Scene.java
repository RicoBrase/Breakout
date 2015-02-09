package de.rico_brase.Breakout.scenes;

import java.awt.Graphics2D;
import java.util.ArrayList;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.IGuiElement;

public abstract class Scene {
	
	protected ArrayList<IGuiElement> guiElements;
	
	public Scene(){
		this.guiElements = new ArrayList<IGuiElement>();
	}
	
	public void handleLeftMouseClick(int xPos, int yPos){
		for(IGuiElement gE : this.guiElements){
			 if(gE.xPos <= xPos && gE.xPos + gE.width >= xPos){
				 if(gE.yPos <= yPos && gE.yPos + gE.height >= yPos){
					 gE.onLeftClick();
				 }
			 }
		}
	}
	
	public void addElement(IGuiElement element){
		guiElements.add(element);
	}
	
	public abstract void init(Screen s);

	public abstract void renderScene(Graphics2D g, Screen s);
	
}
