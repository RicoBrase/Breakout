package de.rico_brase.Breakout.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.ball.Ball;
import de.rico_brase.Breakout.config.Config;
import de.rico_brase.Breakout.scenes.Scenes;

/**
 * Handler für Tastendrücke.
 * @author Rico Brase
 *
 */
public class KeyHandler implements KeyListener{

	Screen s;
	
	int code_step = 0;
	
	public KeyHandler(Screen s){
		this.s = s;
	}
	
	/**
	 * Abfangen von Tastendrücken.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_ESCAPE:
			if(s.getCurrentScene() == Scenes.MAIN_MENU){
				//System.exit(0);
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
			
		case KeyEvent.VK_UP:
			if(s.getCurrentScene() == Scenes.INFO){
				if(code_step == 0 || code_step == 1) code_step++;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(s.getCurrentScene() == Scenes.INFO){
				if(code_step == 2 || code_step == 3) code_step++;
			}
			break;
		case KeyEvent.VK_LEFT:
			if(s.getCurrentScene() == Scenes.INFO){
				if(code_step == 4 || code_step == 6) code_step++;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(s.getCurrentScene() == Scenes.INFO){
				if(code_step == 5 || code_step == 7) code_step++;
			}
			break;
		case KeyEvent.VK_B:
			if(s.getCurrentScene() == Scenes.INFO){
				if(code_step == 8) code_step++;
			}
			break;
		case KeyEvent.VK_A:
			if(s.getCurrentScene() == Scenes.INFO){
				if(code_step == 9){
					code_step = 0;
					JOptionPane.showMessageDialog(Screen.INSTANCE, "Konami-Code aktiviert. Zum Beenden Spiel neustarten.", "Breakout", JOptionPane.INFORMATION_MESSAGE);
					Config.setBoolean(Config.KEY_SPECIAL_IMGS, true);
				}
			}
			break;
			
//		case KeyEvent.VK_F:
//			if(s.getCurrentScene() == Scenes.GAME){
//				PowerUps.FLAME.getPowerUp().start();
//			}
//			break;
//		case KeyEvent.VK_G:
//			if(s.getCurrentScene() == Scenes.GAME){
//				PowerUps.PADDLE_LENGTH.getPowerUp().start();
//			}
//			break;
//		case KeyEvent.VK_H:
//			if(s.getCurrentScene() == Scenes.GAME){
//				PowerUps.EXTRA_LIFE.getPowerUp().start();
//			}
//			break;
		default:
			if(s.getCurrentScene() == Scenes.INFO){
				code_step = 0;
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
