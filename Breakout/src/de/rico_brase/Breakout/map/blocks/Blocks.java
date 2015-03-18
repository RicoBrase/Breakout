package de.rico_brase.Breakout.map.blocks;

import java.awt.Color;

import de.rico_brase.Breakout.scenes.game.SceneGame;

/**
 * Diese Klasse stellt alle möglichen Blocktypen dar.
 * @author Rico Brase
 *
 */
public enum Blocks {

	EMPTY(SceneGame.BACKGROUND_COLOR, 0),
	BLUE(Color.CYAN, 1),
	GREEN(Color.GREEN, 2),
	YELLOW(Color.YELLOW, 3),
	RED(Color.RED, 4),
	BLACK(Color.BLACK, 5);
	
	private Color color;
	private int breakCount;
	
	public static final double WIDTH_MULT = 1.00D/10D;
	public static final double HEIGHT_MULT = 0.50D/10D;
	
	private Blocks(Color color, int breakCount){
		this.color = color;
		this.breakCount = breakCount;
	}
	
	/**
	 * Gibt an, wie oft ein Block mit dem Ball getroffen werden kann, bevor dieser komplett zerstört ist.
	 * @return Die Häufigkeit, wie oft ein Block dieses Blocktyps getroffen werden kann.
	 */
	public int getBreakCount(){
		return this.breakCount;
	}
	
	/**
	 * Gibt die Farbe des Blocktyps zurück.
	 * @return Die Farbe des Blocktyps.
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Gibt den nächst-tieferen Blocktyp zurück.
	 * @return Der nächst-tiefere Blocktyp.
	 */
	public Blocks getBreakedBlock(){
		return (this == EMPTY ? EMPTY : Blocks.values()[this.ordinal()-1]);
	}
	
}
