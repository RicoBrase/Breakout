package de.rico_brase.Breakout.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Spiegelt die Konfigurationsdatei auf der lokalen Festplatte wieder.
 * @author Rico Brase
 * @see java.io.File
 */
public class LocalConfigFile extends File{

	private static final long serialVersionUID = -2632016997393186129L;
	
	/**
	 * Der Pfad zu der Konfigurationsdatei.
	 */
	private static String path = System.getProperty("user.home") + File.separator + "Breakout" + File.separator + "config.bocfg";
	
	/**
	 * Konstruktor der Konfigurationsdatei.
	 * Erstellt eine neue Datei, wenn diese nicht vorhanden ist.
	 */
	public LocalConfigFile(){
		super(path);
		
		if(!this.exists()){
			try {
				this.getParentFile().mkdirs();
				this.createNewFile();
				
				FileWriter writer = new FileWriter(this);
				writer.write("display_special_imgs=false");
				writer.flush();
				writer.close();
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.err.println("Config konnte nicht erstellt werden!");
			}
		}
		
	}
	
	private String readPropertyFromFile(String key){
		
		try{
		
		BufferedReader br = new BufferedReader(new FileReader(this));
		String line;
		
		while((line = br.readLine()) != null){
			
			if(line.trim().isEmpty()){
				continue;
			}
			
			if(line.charAt(0) == '#'){
				continue;
			}
			
			String[] lineData = line.split("=");
			
			if(lineData[0].equals(key)){
				br.close();
				return lineData[1];
			}
			
		}
		
		br.close();
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Liest die Eigenschaft unter den gegebenen Schlüssel aus und gibt sie zurück.
	 * @param key Der Konfigurationsschlüssel.
	 * @return Der Wert des Schlüssels.
	 */
	public Object readProperty(String key){
		
		String result = readPropertyFromFile(key);
		
		if(result.startsWith("\"")){
			return result.substring(1, result.length()-1);
		}
		
		if(Character.isDigit(result.charAt(0))){
			if(result.contains(",") || result.contains(".")){
				result.replaceAll(",", ".");
				return Double.parseDouble(result);
			}
			return Integer.parseInt(result);
		}
		
		if(result.equalsIgnoreCase("true")){
			return true;
		}
		
		if(result.equalsIgnoreCase("false")){
			return false;
		}
		
		return null;
	}
}
