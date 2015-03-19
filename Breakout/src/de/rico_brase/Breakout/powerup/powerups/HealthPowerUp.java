package de.rico_brase.Breakout.powerup.powerups;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.player.Player;
import de.rico_brase.Breakout.powerup.PowerUp;
import de.rico_brase.Breakout.utils.Assets;
import de.rico_brase.Breakout.utils.RenderManager;

public class HealthPowerUp extends PowerUp{

	public HealthPowerUp() {
		super(0, 0.10D);
	}

	@Override
	public void doStuff() {
		Player.INSTANCE.lives++;
	}

	@Override
	public void renderPowerUp(Graphics2D g) {
		RenderManager.renderImageFromAssetsAt(Assets.Game.Powerups.HEALTH_UP, this.xPos, this.yPos, 40, 40, g);
	}
	
	

}
