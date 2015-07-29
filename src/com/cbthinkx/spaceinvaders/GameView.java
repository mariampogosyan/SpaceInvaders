package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GameView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private GameModel model;
	public GameView(GameModel model) {
		this.model = model;
		this.model.addObserver(this);
		this.model.getPlayer().addObserver(this);
		addKeyListener(new playerKeyListnener());
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		AffineTransform gat = new AffineTransform();
		gat.translate(getWidth() / 2.0, -getHeight() / 2.0);
		g2d.scale(1.0, -1.0);
		g2d.transform(gat);
		setBackground(Color.black);
		//Draw Player
		RoundRectangle2D playerBot = new RoundRectangle2D.Float(getModel().getPlayer().getX(),getModel().getPlayer().getY(), 50, 15, 10, 10);
		RoundRectangle2D playerTop = new RoundRectangle2D.Float(getModel().getPlayer().getX(),getModel().getPlayer().getY(), 50, 15, 10, 10);
		g2d.setPaint(Color.GREEN);
		g2d.fill(playerBot);
		g2d.draw(playerBot);
		//
		g2d.dispose();
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

	private class playerKeyListnener extends KeyAdapter{
		PlayerControler player = getModel().getPlayer();
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
