package de.rico_brase.Breakout.map;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.map.blocks.Blocks;
import de.rico_brase.Breakout.scenes.game.SceneGame;

public class Map {

	private Block[][] blocks;
	
	public Map(){
		
		this.blocks = new Block[10][20];
		
		setBlock(0, 0, new Block(Blocks.BLUE, 0, 0));
		setBlock(1, 1, new Block(Blocks.GREEN, 1, 1));
		setBlock(2, 2, new Block(Blocks.YELLOW, 2, 2));
		setBlock(3, 3, new Block(Blocks.RED, 3, 3));
		setBlock(4, 4, new Block(Blocks.BLACK, 4, 4));
		
		setBlock(5, 5, new Block(Blocks.BLUE, 5, 5));
		setBlock(6, 6, new Block(Blocks.GREEN, 6, 6));
		setBlock(7, 7, new Block(Blocks.YELLOW, 7, 7));
		setBlock(8, 8, new Block(Blocks.RED, 8, 8));
		setBlock(9, 9, new Block(Blocks.BLACK, 9, 9));
		
		setBlock(0, 10, new Block(Blocks.BLUE, 0, 10));
		setBlock(1, 11, new Block(Blocks.GREEN, 1, 11));
		setBlock(2, 12, new Block(Blocks.YELLOW, 2, 12));
		setBlock(3, 13, new Block(Blocks.RED, 3, 13));
		setBlock(4, 14, new Block(Blocks.BLACK, 4, 14));
		
		setBlock(5, 15, new Block(Blocks.BLUE, 5, 15));
		setBlock(6, 16, new Block(Blocks.GREEN, 6, 16));
		setBlock(7, 17, new Block(Blocks.YELLOW, 7, 17));
		setBlock(8, 18, new Block(Blocks.RED, 8, 18));
		setBlock(9, 19, new Block(Blocks.BLACK, 9, 19));
	}
	
	public Map(Block[][] blocks){
		this.blocks = blocks;
	}
	
	public void setBlock(int x, int y, Block block){
		this.blocks[x][y]= block;
	}
	
	public Block getBlock(int x, int y){
		return this.blocks[x][y];
	}
	
	public Block getBlockAt(int xPos, int yPos){
		for(int y = 0; y < this.blocks[0].length; y++){
			for(int x = 0; x < this.blocks.length; x++){
				if(xPos >= x*SceneGame.blockWidth && xPos < (x+1) * SceneGame.blockWidth){
					if(yPos >= y*SceneGame.blockHeight && yPos < (y+1) * SceneGame.blockHeight){
						return this.blocks[x][y];
					}
				}
			}
		}
		
		return null;
	}
	
	public void setBlockAt(int xPos, int yPos, Block block){
		for(int y = 0; y < this.blocks[0].length; y++){
			for(int x = 0; x < this.blocks.length; x++){
				if(xPos >= x*SceneGame.blockWidth && xPos < (x+1) * SceneGame.blockWidth){
					if(yPos >= y*SceneGame.blockHeight && yPos < (y+1) * SceneGame.blockHeight){
						this.blocks[x][y] = block;
					}
				}
			}
		}
	}
	
	public void render(Graphics2D g){
		for(int y = 0; y < this.blocks[0].length; y++){
			for(int x = 0; x < this.blocks.length; x++){
				if(this.blocks[x][y] != null)
					this.blocks[x][y].renderBlock(g);
			}
		}
		
		g.setColor(Color.BLACK);
		//g.drawRect(0, 0, this.blocks.length * SceneGame.blockWidth, this.blocks[0].length * SceneGame.blockHeight);
	}
	
	
	
	
}
