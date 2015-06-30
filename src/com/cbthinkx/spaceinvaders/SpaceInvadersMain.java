package com.cbthinkx.spaceinvaders;

import javax.swing.*;
import java.awt.EventQueue;


public class SpaceInvadersMain extends JFrame {
	private static final long serialVersionUID = 1L;
    private int height = 750;
    private int width = 750;
    private GameView panel;
	public SpaceInvadersMain() {
	 	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(width, height);
    	setResizable(false);
    	setLocationRelativeTo(null);
		setVisible(true);
		panel = new GameView();
//		add(panel);
	}
	public static void main(String[] sa) {
		EventQueue.invokeLater(
				() -> new SpaceInvadersMain()
		);
	};

}
