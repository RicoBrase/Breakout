package de.rico_brase.Breakout.map.blocks;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.powerup.PowerUpManager;
import de.rico_brase.Breakout.powerup.PowerUps;
import de.rico_brase.Breakout.scenes.game.SceneGame;

/**
 * Diese Klasse repräsentiert ein Block-Objekt auf dem {@link de.rico_brase.Breakout.map.Map Spielfeld}.
 * @author Rico Brase
 *
 */
public class Block{

	//private int breakCount;
	private Color color;
	
	private Blocks block;
	
	private int xPos = 0;
	private int yPos= 0;
	
	public Block(Blocks block, int xPos, int yPos){
		//this.breakCount = block.getBreakCount();
		this.color = block.getColor();
		
		this.block = block;
		
		this.xPos = (xPos);
		this.yPos = (yPos);
	}
	
	/**
	 * Gibt den {@link de.rico_brase.breakout.map.blocks.Blocks Blocktyp} dieses Blockes zurück.
	 * @return Der {@link de.rico_brase.breakout.map.blocks.Blocks Blocktyp} dieses Blockes.
	 */
	public Blocks getBlockType(){
		return this.block;
	}
	
	public int getXPos(){
		return this.xPos * SceneGame.blockWidth;
	}
	
	/**
	 * Rendert diesen Block.
	 * @param g
	 */
	public void renderBlock(Graphics2D g){
		
		int x = this.xPos * SceneGame.blockWidth;
		int y = this.yPos + (this.yPos * SceneGame.blockHeight);
		
		Color old_color = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, SceneGame.blockWidth, SceneGame.blockHeight);
		if(this.block != Blocks.EMPTY){
			g.setColor(Color.BLACK);
			g.drawRect(x, y, SceneGame.blockWidth, SceneGame.blockHeight);
		}
		
		g.setColor(old_color);
	}
	
	/**
	 * "Zerstört" diesen Block und setzt ihn auf den nächst-tieferen Blocktypen.
	 * @return Das neue Block-Objekt nach der Zerstörung des alten Blocks.
	 */
	public Block breakBlock(){
		Blocks newBlockType = block.getBreakedBlock();
		this.block = newBlockType;
		
		Block newBlock = new Block(newBlockType, this.xPos, this.yPos);
		
		PowerUpManager.add(PowerUps.getRandomPowerUp(newBlock));
		
		return (newBlockType == null ? null : newBlock);
	}
}
