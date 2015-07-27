package com.cbthinkx.spaceinvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControler implements KeyListener {
    private boolean canFire;
    private int score;
    private int highScore;
    private int lives;
    private int x;
    private int y;


    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public boolean canFire() {
        return canFire;
    }

    public void setCanFire(boolean canFire) {
        this.canFire = canFire;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void moveRight() {

    }
    public void moveLeft() {

    }
    public void shootMissile(){

    }
    public void increeseScore(int points) {
        this.score = this.score + points;
        if (this.score > this.highScore) {
            this.highScore = this.score;
        }
    }

}
