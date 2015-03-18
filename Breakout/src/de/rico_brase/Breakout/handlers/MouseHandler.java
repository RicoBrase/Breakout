package de.rico_brase.Breakout.handlers;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ball.Ball;
import de.rico_brase.Breakout.paddle.Paddle;
import de.rico_brase.Breakout.scenes.Scenes;
import de.rico_brase.Breakout.scenes.game.SceneGame;

/**
 * Diese Klasse sorgt dafür, dass Mausklicks von der aktuellen Szene gehandhabt werden können.
 * @author Rico Brase
 *
 */
public class MouseHandler implements MouseInputListener{

	/**
	 * Mausklicks werden an die Szene weitergegeben und dort behandelt.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1){			
			Screen.INSTANCE.getCurrentScene().getScene().handleLeftMouseClick(e.getXOnScreen(), e.getYOnScreen());
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

	/**
	 * Wenn die Maus mit gedrückter Taste bewegt wird, bewegt sich das Paddle horizontal mit.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(Screen.INSTANCE.getCurrentScene() == Scenes.GAME){
			
			int xPos = e.getXOnScreen();
			
			if(!SceneGame.INSTANCE.isPaused()){
				Paddle.setXPos(xPos);
				if(Ball.stickToBar) Ball.setPos(xPos-Ball.width/2, Ball.getYPos());
			}
		}
	}

	/**
	 * Wenn die Maus bewegt wird, bewegt sich das Paddle horizontal mit.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		
		if(Screen.INSTANCE.getCurrentScene() == Scenes.GAME){
			
			int xPos = e.getXOnScreen();
			
			if(!SceneGame.INSTANCE.isPaused()){
				Paddle.setXPos(xPos);
				if(Ball.stickToBar) Ball.setPos(xPos-Ball.width/2, Ball.getYPos());
			}
			
		}
		
	}
}
