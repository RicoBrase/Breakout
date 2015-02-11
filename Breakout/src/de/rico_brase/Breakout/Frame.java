package de.rico_brase.Breakout;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import de.rico_brase.Breakout.handlers.KeyHandler;
import de.rico_brase.Breakout.handlers.MouseHandler;
import de.rico_brase.Breakout.utils.Assets;

public class Frame extends JFrame{

	private static final long serialVersionUID = -5836275440980163014L;

	public static void main(String[] args){
		new Frame();
	}
	
	public Frame(){
		super("Breakout");
		
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		device.setFullScreenWindow(this);
		
		
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
