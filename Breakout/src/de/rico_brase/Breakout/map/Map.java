package de.rico_brase.Breakout.map;

import java.awt.Color;
import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.map.blocks.Blocks;
import de.rico_brase.Breakout.scenes.Scenes;
import de.rico_brase.Breakout.scenes.game.SceneGame;

/**
 * Diese Klasse repräsentiert ein Spielfeld inkl. Blöcke.
 * @author Rico Brase
 *
 */
public class Map {

	public Block[][] blocks;
	
	public Map(Block[][] blocks){
		this.blocks = blocks;
	}
	
	public void setBlock(int x, int y, Block block){
		this.blocks[x][y]= block;
	}
	
	public Block getBlock(int x, int y){
		return this.blocks[x][y];
	}
	
	/**
	 * Gibt den Block an der gegebenen Position zurück.
	 * @param xPos X-Position auf dem Bildschirm.
	 * @param yPos Y-Position auf dem Bildschirm.
	 * @return Der Block an der gegebenen Position.
	 */
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
	
	/**
	 * Setzt den Block an der gegebenen Position.
	 * @param xPos X-Position auf dem Bildschirm.
	 * @param yPos Y-Position auf dem Bildschirm.
	 * @param block Der Block, auf den der an der gegebenen Position gesetzt werden soll.
	 */
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
	
	/**
	 * "Zerstört" den Block an der gegebenen Position.
	 * @param xPos X-Position auf dem Bildschirm.
	 * @param yPos Y-Position auf dem Bildschirm.
	 */
	public void breakBlock(int xPos, int yPos){
		Block block = this.getBlockAt(xPos, yPos);
		if(block != null){
			this.setBlockAt(xPos, yPos, block.breakBlock());
		}
		
		boolean winflag = true;
		
		checkWin: for(Block[] blockArr : blocks){
			for(Block brBlock : blockArr){
				if(brBlock != null){
					if(brBlock.getBlockType() != Blocks.EMPTY){
						winflag = false;
						break checkWin;
					}
				}
			}
		}
		
		if(winflag){
			win();
		}
	}
	
	/**
	 * Ruft die Methode {@link de.rico_brase.Breakout.map.blocks.Block#renderBlock(Graphics2D) Block#renderBlock(Graphics2D)} für jeden Block auf, der in der dieser Welt geladen ist.
	 * @param g
	 */
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
	
	/**
	 * Iniziiert die "Gewonnen"-Szene.
	 */
	public void win(){
		Screen.INSTANCE.setScene(Scenes.WON);
	}
	
	
}
