package de.rico_brase.Breakout.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ball.Ball;
import de.rico_brase.Breakout.ballmovement.Rotation;
import de.rico_brase.Breakout.paddle.Paddle;
import de.rico_brase.Breakout.scenes.Scenes;

public class KeyHandler implements KeyListener{

	Screen s;
	
	public KeyHandler(Screen s){
		this.s = s;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_ESCAPE:
			if(s.getCurrentScene() == Scenes.MAIN_MENU){
				System.exit(0);
			}else
			if(s.getCurrentScene() == Scenes.GAME){
				s.changeScene();
			}
			break;
		case KeyEvent.VK_SPACE:
			if(s.getCurrentScene() == Scenes.GAME && Ball.stickToBar){
				Ball.stickToBar = !Ball.stickToBar;
				//Rotation.addAngle(90);
				//System.out.println(Rotation.getAngle());
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
