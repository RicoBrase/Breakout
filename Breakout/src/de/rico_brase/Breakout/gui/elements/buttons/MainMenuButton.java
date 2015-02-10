package de.rico_brase.Breakout.gui.elements.buttons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.gui.elements.GameButton;

public abstract class MainMenuButton extends GameButton{

	public MainMenuButton(String text, int x, int y, int width, int height) {
		super(text, x, y, width, height);
	}

	@Override
	public void renderButton(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(this.xPos, this.yPos, this.width, this.height);
		g.setColor(new Color(0, 0, 0, 150));
		g.setStroke(new BasicStroke(4F));
		g.drawRect(this.xPos+2, this.yPos+2, this.width-4, this.height-4);
	}

	public abstract void onLeftClick();

}
