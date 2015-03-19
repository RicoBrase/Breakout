package de.rico_brase.Breakout.powerup.powerups;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.powerup.PowerUp;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class PaddlePowerUp extends PowerUp{

	public PaddlePowerUp() {
		super(5, 0.30D);
	}

	@Override
	public void doStuff() {
		
	}

	@Override
	public void renderPowerUp(Graphics2D g) {
		RenderManager.renderImageFromAssetsAt(Assets.Game.Powerups.PADDLE_UP, this.xPos, this.yPos, 40, 40, g);
	}
	

}
