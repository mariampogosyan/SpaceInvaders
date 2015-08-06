package com.cbthinkx.spaceinvaders;

import com.cbthinkx.spaceinvaders.invaders.Crab;
import com.cbthinkx.spaceinvaders.invaders.Invaders;
import com.cbthinkx.spaceinvaders.invaders.JellyFish;
import com.cbthinkx.spaceinvaders.invaders.Octopus;
import com.cbthinkx.spaceinvaders.invaders.Ship;
import com.cbthinkx.spaceinvaders.missiles.Missiles;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;



public class GameModel extends Observable implements ActionListener {
    private ArrayList<Invaders> invaders;
    private ArrayList<Missiles> missiles;
    private ArrayList<Objects> isDead;
    private PlayerControler player;
    private ArrayList<BufferedImage> images;
    private Timer playerTimer;
    private Timer randomShipTimer;

    public GameModel(PlayerControler player, ArrayList<BufferedImage> img) {
        this.player = player;
        this.invaders = new ArrayList<>();
        this.missiles = new ArrayList<>();
        this.isDead = new ArrayList<>();
        this.images = img;
        randomShipTimer = new Timer(10000, null);
        randomShipTimer.addActionListener(
                ae -> {
                    Ship newShip = new Ship(images.get(0), -400, 250);
                    invaders.add(newShip);
                }
        );
        randomShipTimer.setRepeats(true);
        randomShipTimer.start();
        playerTimer = new Timer(25, null);
        playerTimer.addActionListener(
                ae -> {
                    updatePositions();
                    hitDetection();
                }
        );
        playerTimer.setRepeats(true);
        playerTimer.start();
        modImages();
        createInvaders();
    }
    private void modImages() {
    	for (int x = 0; x < images.size(); x++) {
    		int width = images.get(x).getWidth();
    		AffineTransform transform = new AffineTransform();
    		transform.scale(0.35, 0.35);
    		BufferedImage bufferedImage = images.get(x);
    		transform.rotate(Math.PI, bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
    		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    		 bufferedImage = op.filter(bufferedImage, null);
    		 images.set(x, bufferedImage);
    	}
    }

    public void hitDetection() {
        for (int m = 0; m < getMissiles().size(); m++) {
            for (int i = 0; i < getInvaders().size(); i++) {
                int width = getInvaders().get(i).getCurrentFrame().getWidth();
                int height = getInvaders().get(i).getCurrentFrame().getHeight();
                Rectangle2D in = new Rectangle2D.Float(
                        getInvaders().get(i).getX() - (width/2),
                        getInvaders().get(i).getY(),
                        width,
                        height
                );
                if (in.contains(getMissiles().get(m).getShape())) {
                    getPlayer().increeseScore(getInvaders().get(i).getScore());
                    getMissiles().remove(m);
                    getInvaders().remove(i);
                    break;
                }
            }
        }

    }
    public void createInvaders() {
    	int rows = 5;
    	int columns = 11;
    	int ySpacer = 50;
    	int xSpacer = 45;
    	int x = -270;
    	int y = 180;
     	for (int i = rows; i > 0; i--) {
    		for (int j = 0; j < columns; j++) {
    			x = x +  xSpacer;
    			if (i == 5) {
    				Octopus invader = new Octopus(images.get(5), images.get(6), x, y);
    				invaders.add(invader);
    			}
    			if (i == 4 || i == 3) {
    				Crab invader = new Crab(images.get(1), images.get(2), x, y);
    				invaders.add(invader);
    			}
    			if (i == 2 || i == 1) {
    				JellyFish invader = new JellyFish(images.get(3), images.get(4), x, y);
    				invaders.add(invader);
    			}
    			System.out.println("X: " + x + " Y: " + y);
    		}
			y = y - ySpacer;
			x = -270;
    	}
    	
    }
    public void updatePositions() {
        if (this.invaders.size() != 0) {
            for (int i = 0; i < this.invaders.size(); i++) {
                if (this.getInvaders().get(i).isAlive()) {
                    this.invaders.get(i).updatePosition();
                } else {
                    this.invaders.remove(i);
                }
            }
        }
        if (this.missiles.size() != 0) {
        	for (int i = 0; i < getMissiles().size(); i++) {
        		if (getMissiles().get(i).getY() > 257) {
        			this.missiles.remove(i);        			
        		} else {
        			getMissiles().get(i).updatePosition();
        		}
        	}
        	

        }
        if (this.isDead.size() != 0) {

        }
        player.updatePosition();
    	setChanged();
    	notifyObservers();
    }
    
	@Override
	public void actionPerformed(ActionEvent ae) {
	}

    public PlayerControler getPlayer() {
        return player;
    }

    public void setPlayer(PlayerControler player) {
        this.player = player;
    }
    public ArrayList<Missiles> getMissiles(){
		return missiles;
	}
    public ArrayList<Invaders> getInvaders() {
        return invaders;
    }
    public ArrayList<Objects> getIsDead() {
        return isDead;
    }
}
