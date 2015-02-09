package de.rico_brase.Breakout.handlers;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.scenes.Scenes;

public class MouseHandler implements MouseInputListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(Screen.INSTANCE.getCurrentScene() == Scenes.MAIN_MENU){
			Scenes.MAIN_MENU.getScene().handleLeftMouseClick(e.getXOnScreen(), e.getYOnScreen());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}

}
