package de.rico_brase.Breakout.config;

import java.util.HashMap;

/**
 * Enthält die Konfiguration/Optionen des Spieles.
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
	 * Gibt den bool'schen Wert der Konfiguration zurück.
	 * @param key Der Schlüssel.
	 * @return Der Wert des Schlüssels.
	 */
	public static boolean getBoolean(String key){
		return (boolean)map.get(key);
	}
	
	/**
	 * Setze den Wert des Schlüssels in der Konfiguration auf den gegebenen Wert (Wird <b>nicht</b> auf der Festplatte gespeichert!).
	 * @param key Der Konfigurationsschlüssel
	 * @param value Der neue Wert des Schlüssels.
	 */
	public static void setBoolean(String key, boolean value){
		map.put(key, value);
	}
	
}
