package de.rico_brase.Breakout;

import javax.swing.JFrame;

import de.rico_brase.Breakout.handlers.KeyHandler;
import de.rico_brase.Breakout.handlers.MouseHandler;

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
		
		Screen s = new Screen();
		this.add(s);
		
		this.addKeyListener(new KeyHandler(s));
		this.addMouseListener(new MouseHandler());

		this.setVisible(true);
		
	}	
}
