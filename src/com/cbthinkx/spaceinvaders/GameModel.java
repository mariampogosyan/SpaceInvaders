package com.cbthinkx.spaceinvaders;

import com.cbthinkx.spaceinvaders.invaders.Invaders;
import com.cbthinkx.spaceinvaders.missiles.Missiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Queue;
import java.util.Timer;

public class GameModel extends Observable implements ActionListener {
    private ArrayList<Invaders> invaders;
    private ArrayList<Missiles> missiles;
    private Queue<Objects> isDead;
    private PlayerControler player;
    private Timer timer;

    public void hitDetection() {

    }
    public void updatePositions() {
    	setChanged();
    	notifyObservers();
    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		setChanged();
		notifyObservers();
	}
}
