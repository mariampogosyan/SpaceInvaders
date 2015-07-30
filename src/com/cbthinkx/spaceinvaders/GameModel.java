package com.cbthinkx.spaceinvaders;

import com.cbthinkx.spaceinvaders.invaders.Invaders;
import com.cbthinkx.spaceinvaders.missiles.Missiles;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;



public class GameModel extends Observable implements ActionListener {
    private ArrayList<Invaders> invaders;
    private ArrayList<Missiles> missiles;
    private ArrayList<Objects> isDead;
    private PlayerControler player;
    private Timer playerTimer;

    public GameModel(PlayerControler player) {
        this.player = player;
        this.invaders = new ArrayList<>();
        this.missiles = new ArrayList<>();
        this.isDead = new ArrayList<>();
        playerTimer = new Timer(25, this);
        playerTimer.setRepeats(true);
        playerTimer.start();
    }

    public void hitDetection() {

    }
    public void updatePositions() {
        if (this.invaders.size() != 0) {

        }
        if (this.missiles.size() != 0) {
        	for (int i = 0; i < getArrayList().size(); i++) {
        		getArrayList().get(i).updatePosition();
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
        updatePositions();
	}

    public PlayerControler getPlayer() {
        return player;
    }

    public void setPlayer(PlayerControler player) {
        this.player = player;
    }
    public ArrayList<Missiles> getArrayList(){
		return missiles;
	}
    
}
