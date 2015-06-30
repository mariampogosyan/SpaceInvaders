package com.cbthinkx.spaceinvaders;

import java.awt.EventQueue;

import com.cbthinkx.puzzler.menu.ThePuzzler;

public class SpaceInvaders extends JFrame {
	private static final long serialVersionUID = 1L;
    private int height = 750;
    private int width = 750;
    private GameView panel;
	public SpaceInvaders() {
	 	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(width, height);
    	setResizable(false);
    	setLocationRelativeTo(null);
		setVisible(true);
		panel = new GameView();
		add(panel);
	}
	public static void main(String[] sa) {
		EventQueue.invokeLater(
				() -> new SpaceInvaders()
		);
	};

}
