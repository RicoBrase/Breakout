package de.rico_brase.Breakout.scenes;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.scenes.game.SceneGame;
import de.rico_brase.Breakout.scenes.info.SceneInfo;
import de.rico_brase.Breakout.scenes.lost.SceneLost;
import de.rico_brase.Breakout.scenes.mainmenu.SceneMainMenu;
import de.rico_brase.Breakout.scenes.won.SceneWon;

public enum Scenes {

	MAIN_MENU(new SceneMainMenu()),
	GAME(new SceneGame()),
	WON(new SceneWon()),
	LOST(new SceneLost()),
	INFO(new SceneInfo());
	
	private Scene scene;
	private boolean initialized = false;
	
	private Scenes(Scene scene){
		this.scene = scene;
	}
	
	public void renderScene(Graphics2D g, Screen s){
		this.scene.renderScene(g, s);
	}
	
	public Scene getScene(){
		return this.scene;
	}
	
	public Scenes init(Screen s){
		this.scene.init(s);
		this.initialized = true;
		return this;
	}
	
	public boolean isInitialized(){
		return this.initialized;
	}
	
}
