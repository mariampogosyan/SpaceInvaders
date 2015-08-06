package com.cbthinkx.spaceinvaders;

import com.cbthinkx.spaceinvaders.invaders.Invaders;
import com.cbthinkx.spaceinvaders.invaders.Ship;
import com.cbthinkx.spaceinvaders.missiles.Missiles;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
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
                    ArrayList<BufferedImage> ship = new ArrayList<>();
                    ship.add(this.images.get(0));
                    Ship newShip = new Ship(ship, -400, 250);
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
                if (in.contains(getMissiles().get(i).getShape())) {
                    getPlayer().increeseScore(getInvaders().get(i).getScore());
                    getMissiles().remove(m);
                    getInvaders().remove(i);
                }
            }
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
