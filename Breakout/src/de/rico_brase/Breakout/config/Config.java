package de.rico_brase.Breakout.config;

import java.util.HashMap;

public class Config {

	private static HashMap<String,Object> map = new HashMap<String, Object>();
	
	private static LocalConfigFile cfgFile = new LocalConfigFile();
	
	public static String KEY_SPECIAL_IMGS = "display_special_imgs";
	
	private static String[] keys = new String[]{KEY_SPECIAL_IMGS};
	
	public static void loadFromDisk(){
		
		for(String key : keys){
			map.put(key, cfgFile.readProperty(key));
		}
		
	}
	
	public static boolean getBoolean(String key){
		return (boolean)map.get(key);
	}
	
}
