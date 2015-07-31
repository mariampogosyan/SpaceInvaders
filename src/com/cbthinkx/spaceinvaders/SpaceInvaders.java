package com.cbthinkx.spaceinvaders;


import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class SpaceInvaders extends JFrame {
	private static final long serialVersionUID = 1L;
    private int height = 700;
    private int width = 650;
	private BufferedImage playerShip;
	private ArrayList<BufferedImage> resources;
    private GameView panel;
	public SpaceInvaders() {
		super("Space Invaders");
		resources = new ArrayList<>();
		if (!loadResources()) {
			System.exit(0);
		}
	 	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setSize(width, height);
    	setResizable(false);
    	setLocationRelativeTo(null);
		setVisible(true);
		panel = new GameView(new GameModel(new PlayerControler(100, playerShip), resources));
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
				new SpaceInvadersKeyEventDispatcher(
						panel.getModel(),
						panel
				)
		);
		add(panel);
	}
	private boolean loadResources() {
		try {
			File pShip = new File("res/Images/playerShip.png");
			BufferedImage img = ImageIO.read(pShip);
			playerShip = img;
			File imgFile = new File("res/Images/bonusInvader.png"); //0
			resources.add(ImageIO.read(imgFile));
			imgFile = new File("res/Images/crabInvader_1.png"); //1
			resources.add(ImageIO.read(imgFile));
			imgFile = new File("res/Images/crabInvader_2.png"); //2
			resources.add(ImageIO.read(imgFile));
			imgFile = new File("res/Images/jellyFishInvader_1.png"); //3
			resources.add(ImageIO.read(imgFile));
			imgFile = new File("res/Images/crabInvader_2.png"); //4
			resources.add(ImageIO.read(imgFile));
			imgFile = new File("res/Images/octopusInvader_1.png"); //5
			resources.add(ImageIO.read(imgFile));
			imgFile = new File("res/Images/crabInvader_2.png"); //6
			resources.add(ImageIO.read(imgFile));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] sa) {
		EventQueue.invokeLater(
				() -> new SpaceInvaders()
		);
	};

}
