package com.cbthinkx.spaceinvaders;

import java.awt.image.BufferedImage;
import java.util.Observable;

public class PlayerControler extends Observable {
    public enum Direction {
        LEFT,RIGHT,STOP
    }
    private boolean canFire;
    private int score;
    private int highScore;
    private int round;
    private int lives;
    private Direction direction;
    private int x;
    private int y;
    private BufferedImage playerShip;


    public PlayerControler(int highScore, BufferedImage ship)  {
        this.playerShip = ship;
        this.highScore = highScore;
        this.score = 0;
        this.canFire = true;
        this.lives = 3;
        this.direction = Direction.STOP;
        this.x = 0;
        this.y = -280;
    }
    public int getScore() {
        return score;
    }
    public int getHighScore() {
        return highScore;
    }
    public void moveRight() {
        this.direction = Direction.RIGHT;
    }
    public void moveLeft() {
        this.direction = Direction.LEFT;
    }
    public void stopMoving() {
        this.direction = Direction.STOP;
        setChanged();
        notifyObservers();
    }
    public void updatePosition() {
        if (this.direction == Direction.RIGHT) {
            this.x = x + 5;
            if (x + (playerShip.getWidth()/2) > 325) {
                this.x = 325 - (playerShip.getWidth()/2);
            }
            setChanged();
            notifyObservers();
        }
        if (this.direction == Direction.LEFT) {
            this.x = x - 5;
            if (x - (playerShip.getWidth()/2) < -325) {
                this.x = -325 + (playerShip.getWidth()/2);
            }
            setChanged();
            notifyObservers();
        }
    }
    public BufferedImage getPlayerShip() {
        return playerShip;
    }
    public void setPlayerShip(BufferedImage playerShip) {
        this.playerShip = playerShip;
    }
    public void increeseScore(int points) {
        this.score = this.score + points;
        if (this.score > this.highScore) {
            this.highScore = this.score;
        }
    }
    public void nextRound() {
        this.round = this.round++;
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
    public int getRound() {
        return round;
    }
    @Override
    public String toString() {
        return "PlayerControler{" +
                "canFire=" + canFire +
                ", score=" + score +
                ", highScore=" + highScore +
                ", lives=" + lives +
                ", direction=" + direction +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
