package de.rico_brase.Breakout.map;

import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.map.blocks.Block;
import de.rico_brase.Breakout.map.blocks.Blocks;

/**
 * Diese Klasse liest *.bomap-Dateien ein und konvertiert diese in ein {@link de.rico_brase.Breakout.map.Map Map}-Objekt, damit diese gerendert werden kann.
 * @author Rico Brase
 *
 */
public class MapLoader {

	/**
	 * Liest *.bomap-Dateien ein und erstellt daraus ein {@link de.rico_brase.Breakout.map.Map Map}-Objekt.
	 * @param file Die einzulesende Datei.
	 * @return Das {@link de.rico_brase.Breakout.map.Map Map}-Objekt, welches aus der gegebenen Datei erstellt wurde.
	 */
	public static Map loadMapFromFile(File file){
		
		int lnNr = 0;
		
		try{
			
			Block[][] blocks = new Block[10][20];
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			
			Screen.INSTANCE.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			
			
			while((line = br.readLine()) != null){
				lnNr++;
				
				if(line.trim().isEmpty()){
					continue;
				}
				
				if(!Character.isDigit(line.charAt(0))){
					continue;
				}
				
				String[] lineData = line.split(";");
				int xPos = Integer.parseInt(lineData[0]);
				int yPos = Integer.parseInt(lineData[1]);
				
				blocks[xPos][yPos] = new Block(Blocks.values()[Integer.parseInt(lineData[2])], xPos, yPos);
			}
			
			Screen.INSTANCE.setCursor(Cursor.getDefaultCursor());
			
			br.close();
			
			//System.out.println("[Debug] Successfully loaded map: " + file.getName());
			
			return new Map(blocks);
			
		}catch(Exception ex){
			System.err.println("[Debug] Failed to read Mapfile: " + file.getName() + ":" + lnNr);
			Screen.INSTANCE.setCursor(Cursor.getDefaultCursor());
		}
		
		return null;
	}
	
}
