package de.rico_brase.Breakout.powerup.powerups;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.powerup.PowerUp;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class FlamePowerUp extends PowerUp{

	public FlamePowerUp() {
		super(5, 0.10D);
	}

	@Override
	public void doStuff() {
		
	}

	@Override
	public void renderPowerUp(Graphics2D g) {
		RenderManager.renderImageFromAssetsAt(Assets.Game.Powerups.FLAME_UP, this.xPos, this.yPos, 40, 40, g);
	}

}
