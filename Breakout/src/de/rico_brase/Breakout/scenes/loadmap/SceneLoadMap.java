package de.rico_brase.Breakout.scenes.loadmap;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.gui.elements.IGuiElement;
import de.rico_brase.Breakout.gui.elements.TextField;
import de.rico_brase.Breakout.gui.elements.buttons.MainMenuButton;
import de.rico_brase.Breakout.map.MapLoader;
import de.rico_brase.Breakout.scenes.Scene;
import de.rico_brase.Breakout.scenes.Scenes;

public class SceneLoadMap extends Scene{
	
	private File mapFile = null;

	@Override
	public void init(Screen s) {
		
		this.addElement(new TextField("Klicken, um Map zu laden...", Screen.WIDTH/4, Screen.HEIGHT/2-50, Screen.WIDTH/2, 100){

			@Override
			public void renderTextField(Graphics2D g) {
				g.setColor(new Color(170, 200, 0));
				g.fillRect(this.xPos, this.yPos, this.width, this.height);
				g.setColor(new Color(0, 0, 0, 150));
				g.setStroke(new BasicStroke(4F));
				g.drawRect(this.xPos+2, this.yPos+2, this.width-4, this.height-4);
			}

			@Override
			public void onLeftClick() {
				final JFileChooser fileDiag = new JFileChooser();
				fileDiag.setAcceptAllFileFilterUsed(false);
				fileDiag.setFileFilter(new FileFilter(){

					@Override
					public boolean accept(File f) {
						if(f.isDirectory()){
							return true;
						}
						
						String ext = f.getName().substring(f.getName().lastIndexOf('.'), f.getName().length());
						if(ext != null){
							if(ext.equalsIgnoreCase(".bomap")){
								return true;
							}
						}
						
						return false;
					}

					@Override
					public String getDescription() {
						return "Breakout Maps";
					}
					
				});
				int result = fileDiag.showDialog(Screen.INSTANCE, "Map laden ...");
				if(result == JFileChooser.APPROVE_OPTION){
					mapFile = fileDiag.getSelectedFile();
					this.setText("Map: " + mapFile.getName());
				}
				
			}
			
		});
		
		this.addElement(new MainMenuButton("Map Laden", Screen.WIDTH/4, Screen.HEIGHT-230, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick() {
				if(mapFile == null){
					mapFile = new File("");
				}
				Screen.INSTANCE.newGame(MapLoader.loadMapFromFile(mapFile));
			}
		});
		
		this.addElement(new MainMenuButton("Zurück ins Hauptmenü", Screen.WIDTH/4, Screen.HEIGHT-120, Screen.WIDTH/2, 100) {
			
			@Override
			public void onLeftClick() {
				Screen.INSTANCE.setScene(Scenes.MAIN_MENU);
			}
		});
	}

	@Override
	public void renderScene(Graphics2D g, Screen s) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		
		for(IGuiElement gE : this.guiElements){
			gE.render(g);
		}
	}

	@Override
	public void onSceneLoaded() {
		
	}

}
