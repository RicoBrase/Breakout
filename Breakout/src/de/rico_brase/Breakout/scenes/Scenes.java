package de.rico_brase.Breakout.scenes;

import java.awt.Graphics2D;

import de.rico_brase.Breakout.Screen;
import de.rico_brase.Breakout.scenes.game.SceneGame;
import de.rico_brase.Breakout.scenes.info.SceneInfo;
import de.rico_brase.Breakout.scenes.loadmap.SceneLoadMap;
import de.rico_brase.Breakout.scenes.lost.SceneLost;
import de.rico_brase.Breakout.scenes.mainmenu.SceneMainMenu;
import de.rico_brase.Breakout.scenes.won.SceneWon;

/**
 * Auflistung aller existenten Szenen.
 * @author Rico Brase
 *
 */
public enum Scenes {

	MAIN_MENU(new SceneMainMenu()),
	GAME(new SceneGame()),
	WON(new SceneWon()),
	LOST(new SceneLost()),
	INFO(new SceneInfo()),
	LOAD_MAP(new SceneLoadMap());
	
	private Scene scene;
	private boolean initialized = false;
	
	private Scenes(Scene scene){
		this.scene = scene;
	}
	
	/**
	 * Methode ruft die jeweilige render-Methode der Szene auf.
	 * @param g
	 * @param s
	 */
	public void renderScene(Graphics2D g, Screen s){
		this.scene.renderScene(g, s);
	}
	
	/**
	 * Gibt die Instanz der Szene zurück.
	 * @return Instanz der Szene.
	 */
	public Scene getScene(){
		return this.scene;
	}
	
	/**
	 * Initialisiert die Szene.
	 * @param s
	 * @return
	 */
	public Scenes init(Screen s){
		this.scene.init(s);
		this.initialized = true;
		return this;
	}
	
	/**
	 * Gibt zurück, ob die Szene bereits initialisiert wurde.
	 * @return Wurde die Szene initialisiert?
	 */
	public boolean isInitialized(){
		return this.initialized;
	}
	
}
