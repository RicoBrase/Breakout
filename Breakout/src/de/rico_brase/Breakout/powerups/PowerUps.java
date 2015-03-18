package de.rico_brase.Breakout.powerups;

import de.rico_brase.Breakout.player.Player;

public enum PowerUps {

	FLAME(new PowerUp(5){
		public void doStuff(){
			
		}
	}),
	PADDLE_LENGTH(new PowerUp(5){
		public void doStuff(){
			
		}
	}),
	EXTRA_LIFE(new PowerUp(0){
		public void doStuff(){
			Player.INSTANCE.lives++;
		}
	});
	
	private PowerUp pu;
	
	private PowerUps(PowerUp pu){
		this.pu = pu;
	}
	
	public PowerUp getPowerUp(){
		return this.pu;
	}
	
	
}
