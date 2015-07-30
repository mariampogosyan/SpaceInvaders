package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.cbthinkx.spaceinvaders.missiles.Missiles;

public class GameView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private static final int LIVES_STARTING_POINT = 65;
	private GameModel model;
	private Font invadersFont;
	private Missiles missile;
	private Shape missileShape;
	public GameView(GameModel model) {
		this.model = model;
		this.model.addObserver(this);
		this.model.getPlayer().addObserver(this);
		loadRes();
		addKeyListener(new playerKeyListnener());
	}
	private void loadRes() {
		try {
			invadersFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/Fonts/ca.ttf")).deriveFont(Font.PLAIN,24f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/Fonts/ca.ttf")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not Find Font");
		}

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		drawScore(g2d);
		drawLives(g2d);
		AffineTransform gat = new AffineTransform();
		gat.translate(getWidth() / 2.0, -getHeight() / 2.0);
		g2d.scale(1.0, -1.0);
		g2d.transform(gat);
		setBackground(Color.black);
		//Draw Player
		RoundRectangle2D playerBot = new RoundRectangle2D.Float(
				getModel().getPlayer().getX(),
				getModel().getPlayer().getY(),
				50, 15,
				10, 10
		);
		drawMissles(g2d);
		g2d.setPaint(Color.GREEN);
		g2d.fill(playerBot);
		g2d.draw(playerBot);
		g2d.dispose();
	}
	private Graphics2D drawMissles(Graphics2D g2d) {
		if(!getModel().getArrayList().isEmpty()){
			for(int i = 0; i < getModel().getArrayList().size(); i++) {
				missileShape = getModel().getArrayList().get(i).getShape();				
				g2d.setPaint(Color.WHITE);
				g2d.fill(missileShape);
				g2d.draw(missileShape);
			}
		}
		return g2d;
	}
	private Graphics2D drawScore(Graphics2D g2d) {
		g2d.setPaint(Color.WHITE);
		g2d.setFont(invadersFont);
		g2d.drawString("SCORE", 15, 25);
		g2d.drawString(String.format("%04d", getModel().getPlayer().getScore()), 22, 50);
		g2d.drawString("HI-SCORE", 495, 25);
		g2d.drawString(String.format("%04d", getModel().getPlayer().getHighScore()), 535, 50);
		return g2d;
	}
	private Graphics2D drawLives(Graphics2D g2d) {
		g2d.setPaint(Color.WHITE);
		g2d.setFont(invadersFont);
		int lives = getModel().getPlayer().getLives();
		g2d.drawString(String.format("%02d", lives), 15, 615);
		for (int x = 0; x < lives; x++) {
			RoundRectangle2D ship = new RoundRectangle2D.Double(LIVES_STARTING_POINT + (45 * x), 605, 40, 10, 10, 10);
			g2d.setPaint(Color.GREEN);
			g2d.fill(ship);
			g2d.draw(ship);
		}
		return g2d;
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
					missile = new Missiles(getModel().getPlayer().getX(), getModel().getPlayer().getY());
					getModel().getArrayList().add(missile);
					player.increeseScore(10);
					if (player.canFire()) {
					
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
