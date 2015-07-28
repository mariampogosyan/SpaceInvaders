package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GameView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private GameModel model;
	private PlayerControler player;
	public GameView() {
		setBackground(Color.BLACK);
	}
	public void gameChanged() {

	}
	GameModel getModel() {
		return this.model;
	}
	void setGameModel(GameModel model) {
		this.model = model;
		getModel().addObserver(this);		
	}
	@Override
	public void paintComponent(Graphics G) {

	}
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}


}
