package de.rico_brase.Breakout.handlers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import de.rico_brase.Breakout.Frame;
import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ball.Ball;
import de.rico_brase.Breakout.bar.Bar;
import de.rico_brase.Breakout.scenes.Scenes;

public class MouseHandler implements MouseInputListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1){
		
			if(Screen.INSTANCE.getCurrentScene() == Scenes.MAIN_MENU){
				Scenes.MAIN_MENU.getScene().handleLeftMouseClick(e.getXOnScreen(), e.getYOnScreen());
			}
		
			if(Screen.INSTANCE.getCurrentScene() == Scenes.GAME){
				Scenes.GAME.getScene().handleLeftMouseClick(e.getXOnScreen(), e.getYOnScreen());
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getComponent().getClass() == Frame.class && Screen.INSTANCE.getCurrentScene() == Scenes.GAME){
			
			try {
				Robot robot = new Robot();
				//robot.mouseMove(e.getXOnScreen()-100, e.getYOnScreen());
				
				e.consume();
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(Screen.INSTANCE.getCurrentScene() == Scenes.GAME){
			
			int xPos = e.getXOnScreen();
			
			Bar.setXPos(xPos);
			if(Ball.stickToBar) Ball.setPos(xPos-Ball.width/2, Ball.getYPos());
			
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(Screen.INSTANCE.getCurrentScene() == Scenes.GAME){
			
			int xPos = e.getXOnScreen();
			
//			try {
//				Robot robot = new Robot();
//				//robot.mouseMove(Screen.INSTANCE.getWidth()/2, Screen.INSTANCE.getHeight()/2);
//			} catch (AWTException e1) {
//				e1.printStackTrace();
//			}
			
			Bar.setXPos(xPos);
			if(Ball.stickToBar) Ball.setPos(xPos-Ball.width/2, Ball.getYPos());
			
			
		}
		
	}
}
