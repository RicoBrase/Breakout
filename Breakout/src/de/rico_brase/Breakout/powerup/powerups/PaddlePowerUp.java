package de.rico_brase.Breakout.powerup.powerups;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.powerup.PowerUp;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Das "Paddle"-PowerUp verdoppelt für die Dauer des Effektes die Breite des Paddles.
 * @author Rico Brase
 *
 */
public class PaddlePowerUp extends PowerUp{

	public PaddlePowerUp() {
		super(5, 0.30D);
	}

	/**
	 * @see de.rico_brase.Breakout.powerup.PowerUp#doStuff()
	 */
	@Override
	public void doStuff() {
		
	}

	/**
	 * @see de.rico_brase.Breakout.powerup.PowerUp#renderPowerUp(Graphics2D)
	 */
	@Override
	public void renderPowerUp(Graphics2D g) {
		RenderManager.renderImageFromAssetsAt(Assets.Game.Powerups.PADDLE_UP, this.xPos, this.yPos, 40, 40, g);
	}
	

}
