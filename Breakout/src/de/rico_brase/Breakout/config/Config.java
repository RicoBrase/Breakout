package de.rico_brase.Breakout.config;

import java.util.HashMap;

/**
 * Enth�lt die Konfiguration/Optionen des Spieles.
 * @author Rico Brase
 */
public class Config {

	private static HashMap<String,Object> map = new HashMap<String, Object>();
	
	private static LocalConfigFile cfgFile = new LocalConfigFile();
	
	public static String KEY_SPECIAL_IMGS = "display_special_imgs";
	
	private static String[] keys = new String[]{KEY_SPECIAL_IMGS};
	
	/**
	 * Lade die Konfiguration aus der lokalen Konfigurationsdatei.
	 * @see de.rico_brase.Breakout.config.LocalConfigFile#readProperty(String)
	 */
	public static void loadFromDisk(){
		
		for(String key : keys){
			map.put(key, cfgFile.readProperty(key));
		}
		
	}
	
	/**
	 * Gibt den bool'schen Wert der Konfiguration zur�ck.
	 * @param key Der Schl�ssel.
	 * @return Der Wert des Schl�ssels.
	 */
	public static boolean getBoolean(String key){
		return (boolean)map.get(key);
	}
	
	/**
	 * Setze den Wert des Schl�ssels in der Konfiguration auf den gegebenen Wert (Wird <b>nicht</b> auf der Festplatte gespeichert!).
	 * @param key Der Konfigurationsschl�ssel
	 * @param value Der neue Wert des Schl�ssels.
	 */
	public static void setBoolean(String key, boolean value){
		map.put(key, value);
	}
	
}
