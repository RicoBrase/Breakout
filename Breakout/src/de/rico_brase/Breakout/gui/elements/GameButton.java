package de.rico_brase.Breakout.gui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Abstrakte Klasse, die einen Button repräsentiert.
 * Alle untergeordneten Klassen müssen die abstrakten Methoden
 * <ul>
 * <li>{@link de.rico_brase.Breakout.gui.elements.GameButton#renderButton(Graphics2D) renderButton(Graphics2D)}</li>
 * <li>{@link de.rico_brase.Breakout.gui.elements.GameButton#onLeftClick() onLeftClick()}</li>
 * </ul>
 * implementieren.
 * @author Rico Brase
 *
 */
public abstract class GameButton extends IGuiElement{
	
	private String text = "";
	
	public GameButton(String text, int x, int y, int width, int height){
		this.text = text;
		setBounds(x, y, width, height);
	}
	
	/**
	 * Rendert den Button.
	 * Hierbei wird das Aussehen des Knopfes festgelegt.
	 * @param g
	 */
	public abstract void renderButton(Graphics2D g);
	
	/**
	 * Rendert vordefinierte Eigenschaften des Buttons, zum Beispiel den Text.
	 */
	public void render(Graphics2D g){
		renderButton(g);
		
		Font orig_font = g.getFont();
		Font font = g.getFont();
		
		g.setColor(Color.BLACK);
		g.setFont(font.deriveFont(15F).deriveFont(Font.BOLD));
		
		RenderManager.drawStringCentered(text, this.width, this.height, this.xPos, this.yPos, (Graphics2D)g);
		g.setFont(orig_font);
	}
	
	/**
	 * Die Aktion, die ausgeführt wird, sobald der Knopf geklickt wird.
	 */
	public abstract void onLeftClick();
	
}
