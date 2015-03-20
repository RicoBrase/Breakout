package de.rico_brase.Breakout.powerup.powerups;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.powerup.PowerUp;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

/**
 * Das "Flame"-PowerUp l�sst den Ball f�r die Dauer des Effektes alle Bl�cke mit einem Treffer zerst�ren.
 * @author Rico Brase
 *
 */
public class FlamePowerUp extends PowerUp{

	public FlamePowerUp() {
		super(5, 0.10D);
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
		RenderManager.renderImageFromAssetsAt(Assets.Game.Powerups.FLAME_UP, this.xPos, this.yPos, 40, 40, g);
	}

}
