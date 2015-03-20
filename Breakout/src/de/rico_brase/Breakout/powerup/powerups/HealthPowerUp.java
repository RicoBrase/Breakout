package de.rico_brase.Breakout.powerup.powerups;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.player.Player;
import de.rico_brase.Breakout.powerup.PowerUp;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Das "Health"-PowerUp erhöht die Lebensanzahl des Spielers um "1".
 * @author Rico Brase
 *
 */
public class HealthPowerUp extends PowerUp{

	public HealthPowerUp() {
		super(0, 0.10D);
	}

	/**
	 * @see de.rico_brase.Breakout.powerup.PowerUp#doStuff()
	 */
	@Override
	public void doStuff() {
		Player.INSTANCE.lives++;
	}

	/**
	 * @see de.rico_brase.Breakout.powerup.PowerUp#renderPowerUp(Graphics2D)
	 */
	@Override
	public void renderPowerUp(Graphics2D g) {
		RenderManager.renderImageFromAssetsAt(Assets.Game.Powerups.HEALTH_UP, this.xPos, this.yPos, 40, 40, g);
	}
	
	

}
