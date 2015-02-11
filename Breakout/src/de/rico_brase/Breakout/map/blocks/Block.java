package de.rico_brase.Breakout.map.blocks;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.scenes.game.SceneGame;

public class Block{

	private int breakCount;
	private Color color;
	
	private Blocks block;
	
	private int xPos = 0;
	private int yPos= 0;
	
	public Block(Blocks block, int xPos, int yPos){
		this.breakCount = block.getBreakCount();
		this.color = block.getColor();
		
		this.block = block;
		
		this.xPos = (xPos);
		this.yPos = (yPos);
	}
	
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
	
	public Block breakBlock(){
		Blocks newBlock = block.getBreakedBlock();
		this.block = newBlock;
		return (newBlock == null ? null : new Block(newBlock, this.xPos, this.yPos));
	}
}
