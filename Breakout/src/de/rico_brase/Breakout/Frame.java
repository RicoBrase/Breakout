package de.rico_brase.Breakout;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;

import de.rico_brase.Breakout.config.Config;
import de.rico_brase.Breakout.handlers.KeyHandler;
import de.rico_brase.Breakout.handlers.MouseHandler;
import de.rico_brase.Breakout.utils.Assets;

/**
 * Dies ist das Fenster, in welchem das Spiel sichtbar ist.
 * @author Rico Brase
 *
 */
public class Frame extends JFrame{

	private static final long serialVersionUID = -5836275440980163014L;

	public static void main(String[] args){
		new Frame();
	}
	
	public Frame(){
		super("Breakout");
		
		Config.loadFromDisk();
		
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//		if(device.isFullScreenSupported() && GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length > 1){
//			//System.out.println("[Debug] Fullscreen supported. Activating ...");
//			device.setFullScreenWindow(this);
//		}
		
		
		Screen s = new Screen();
		this.add(s);
		
		this.addKeyListener(new KeyHandler(s));
		this.addMouseListener(new MouseHandler());
		this.addMouseMotionListener(new MouseHandler());
		
		List<Image> icons = new ArrayList<Image>();
		icons.add(Assets.getImageFromAssets(Assets.General.ICON_64));
		
		this.setIconImages(icons);

		this.setVisible(true);
		
	}	
}
