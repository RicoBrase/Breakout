package de.rico_brase.Breakout.scenes;

import java.awt.Graphics2D;
import java.util.ArrayList;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.IGuiElement;

/**
 * Eine abstrakte Klasse, um Szenen einfacher erstellen zu können.
 * @author Rico Brase
 *
 */
public abstract class Scene {
	
	protected ArrayList<IGuiElement> guiElements;
	
	public Scene(){
		this.guiElements = new ArrayList<IGuiElement>();
	}
	
	/**
	 * Das Mausklick-Event des {@link de.rico_brase.Breakout.handlers.MouseHandler MouseHandler}s wird hier ausgewertet.
	 * @param xPos Die x-Position der Maus.
	 * @param yPos Die y-Position der Maus.
	 */
	public void handleLeftMouseClick(int xPos, int yPos){
		for(IGuiElement gE : this.guiElements){
			 if(gE.xPos <= xPos && gE.xPos + gE.width >= xPos){
				 if(gE.yPos <= yPos && gE.yPos + gE.height >= yPos){
					 gE.onLeftClick();
				 }
			 }
		}
	}
	
	/**
	 * Fügt ein GUI-Element zur Szene hinzu.
	 * @param element
	 */
	public void addElement(IGuiElement element){
		guiElements.add(element);
	}
	
	/**
	 * Wird beim ersten Aufruf einer Szene ausgeführt (einmal pro Prozess).
	 * @param s Die Screen-Instanz, auf der die Szene dargestellt wird.
	 */
	public abstract void init(Screen s);

	/**
	 * Rendert die Szene. Aus dieser Methode werden auch die sub-render-Methoden ausgeführt (Paddle, Ball, etc.).
	 * @param g
	 * @param s
	 */
	public abstract void renderScene(Graphics2D g, Screen s);
	
	/**
	 * Wird jedesmal ausgeführt, wenn die Szene geladen wird.
	 */
	public abstract void onSceneLoaded();
	
}
