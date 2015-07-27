package com.cbthinkx.spaceinvaders;

import com.cbthinkx.spaceinvaders.invaders.Invaders;
import com.cbthinkx.spaceinvaders.missiles.Missiles;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;
import java.util.Timer;

public class GameModel {
    private ArrayList<Invaders> invaders;
    private ArrayList<Missiles> missiles;
    private Queue<Objects> isDead;
    private PlayerControler player;
    private Timer timer;

    public void hitDetection() {

    }
    public void updatePositions() {

    }
}
