package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	public GameModel getModel() {
		return model;
	}

	public void setModel(GameModel model) {
		this.model = model;
	}

	public PlayerControler getPlayer() {
		return player;
	}

	public void setPlayer(PlayerControler player) {
		this.player = player;
	}

	private class playerKeyListnener extends KeyAdapter{
		PlayerControler player = getModel().getPlayer();
		@Override
		public void keyTyped(KeyEvent e) {
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch( keyCode ) {
				case KeyEvent.VK_UP:
					// do nothing
					break;
				case KeyEvent.VK_DOWN:
					// do nothing
					break;
				case KeyEvent.VK_LEFT:
					// move player left
					this.player.moveLeft();
					break;
				case KeyEvent.VK_RIGHT :
					// move player right
					player.moveRight();
					break;
				case KeyEvent.VK_SPACE :
					// shoot missile
					if (player.canFire()) {
						player.shootMissile();
					}
					break;
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch( keyCode ) {
				case KeyEvent.VK_UP:
					// do nothing
					break;
				case KeyEvent.VK_DOWN:
					// do nothing
					break;
				case KeyEvent.VK_LEFT:
					// stop moving left
					player.stopMoving();
					break;
				case KeyEvent.VK_RIGHT :
					// stop moving right
					player.stopMoving();
					break;
				case KeyEvent.VK_SPACE :
					// do nothing
					break;
			}
		}
	}

}
