package de.rico_brase.Breakout.map;

import java.awt.Color;
import java.awt.Graphics2D;

public class MapRenderer {

	public static Map map;
	
	public static void setMap(Map map){
		MapRenderer.map = map;
	}
	
	public static Map getLoadedMap(){
		return MapRenderer.map;
	}
	
	public static void renderMap(Graphics2D g){
		
		Color orig_color = g.getColor();
		
		map.render(g);
		
		g.setColor(orig_color);
		
	}
	
}
