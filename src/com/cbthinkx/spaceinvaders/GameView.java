package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GameView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private GameModel model;
	private PlayerControler player;
	public GameView() {
	}
	@Override
	public void paintComponent(Graphics G) {
		setBackground(Color.black);
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
		getModel().addObserver(this);
	}

	public PlayerControler getPlayer() {
		return this.player;
	}

	public void setPlayer(PlayerControler player) {
		this.player = player;
		addKeyListener(new playerKeyListnener());
	}

	private class playerKeyListnener extends KeyAdapter{
		PlayerControler player = getPlayer();
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
