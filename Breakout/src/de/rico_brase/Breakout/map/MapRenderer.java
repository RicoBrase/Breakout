package de.rico_brase.Breakout.map;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Diese Klasse rendert die gegebene Map.
 * @author Rico Brase
 *
 */
public class MapRenderer {

	/**
	 * Die derzeit geladene Map.
	 */
	public static Map map;
	
	/**
	 * Setzt die zu ladende Map.
	 * @param map Die zu ladende Map.
	 */
	public static void setMap(Map map){
		MapRenderer.map = map;
	}
	
	/**
	 * Gibt die derzeit geladene Map zurück.
	 * @return Die derzeit geladene Map.
	 */
	public static Map getLoadedMap(){
		return MapRenderer.map;
	}
	
	/**
	 * Rendert die aktuell geladene Map im {@link de.rico_brase.Breakout.Screen Spiel-JPanel}.
	 * @param g
	 */
	public static void renderMap(Graphics2D g){
		
		Color orig_color = g.getColor();
		
		map.render(g);
		
		g.setColor(orig_color);
		
	}
	
}
