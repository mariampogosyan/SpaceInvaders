package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.cbthinkx.spaceinvaders.missiles.Missiles;

public class GameView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private static final int LIVES_STARTING_POINT = 65;
	private GameModel model;
	private Font invadersFont;
	private Missiles missile;
	private Shape missileShape;
	private Timer t;
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
		g2d.scale(1.0, -1.0);
		gat.translate(getWidth() / 2.0, -getHeight() / 2.0);
		g2d.transform(gat);
		setBackground(Color.black);
		drawPlayer(g2d);
		drawMissles(g2d);
		g2d.dispose();
	}
	private Graphics2D drawPlayer(Graphics2D g2d) {
		int x = getModel().getPlayer().getX();
		int y = getModel().getPlayer().getY();
		int width = getModel().getPlayer().getPlayerShip().getWidth();
		AffineTransform transform = new AffineTransform();
		BufferedImage bufferedImage = getModel().getPlayer().getPlayerShip();
		transform.rotate(Math.PI, bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		bufferedImage = op.filter(bufferedImage, null);
		g2d.drawImage(bufferedImage, null, x - (width/2), y);
		return g2d;
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
		g2d.setPaint(Color.GREEN);
		g2d.drawLine(0, 60, 650, 60);
		return g2d;
	}
	private Graphics2D drawLives(Graphics2D g2d) {
		g2d.setPaint(Color.WHITE);
		g2d.setFont(invadersFont);
		int lives = getModel().getPlayer().getLives();
		g2d.drawString(String.format("%02d", lives), 15, 665);
		int width = (getModel().getPlayer().getPlayerShip().getWidth()/2) + 25;
		AffineTransform transform = new AffineTransform();
		BufferedImage bufferedImage = getModel().getPlayer().getPlayerShip();
		transform.scale(0.7, 0.7);
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		bufferedImage = op.filter(bufferedImage, null);
		for (int x = 0; x < lives; x++) {
			g2d.drawImage(
					bufferedImage,
					null,
					LIVES_STARTING_POINT + (width * x),
					640
			);
		}
		g2d.setPaint(Color.GREEN);
		g2d.drawLine(0, 635, 650, 635);
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
					if(!getModel().getArrayList().isEmpty()) {
//						t = new Timer(1000, new ActionListener() {
//													
//							}
//						});
//						missile = new Missiles(getModel().getPlayer().getX() - 1, getModel().getPlayer().getY() + 30);
//						getModel().getArrayList().add(missile);  				
//				
//						t.setRepeats(true);
//						t.start();
					
				
					} else {
						missile = new Missiles(getModel().getPlayer().getX() - 1, getModel().getPlayer().getY() + 30);
						getModel().getArrayList().add(missile);
						player.increeseScore(10);
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
