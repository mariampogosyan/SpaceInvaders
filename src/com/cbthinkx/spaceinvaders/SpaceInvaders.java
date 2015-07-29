package com.cbthinkx.spaceinvaders;


import javax.swing.*;

import java.awt.*;


public class SpaceInvaders extends JFrame {
	private static final long serialVersionUID = 1L;
    private int height = 650;
    private int width = 650;
    private GameView panel;
	public SpaceInvaders() {
		super("Space Invaders");
	 	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(width, height);
    	setResizable(false);
    	setLocationRelativeTo(null);
		setVisible(true);
		panel = new GameView();
		panel.setModel(new GameModel());
		panel.setPlayer(new PlayerControler(100));
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new SpaceInvadersKeyEventDispatcher(panel.getModel(), panel));
		add(panel);
	}
	public static void main(String[] sa) {
		EventQueue.invokeLater(
				() -> new SpaceInvaders()
		);
	};

}
