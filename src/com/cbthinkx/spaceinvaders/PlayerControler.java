package com.cbthinkx.spaceinvaders;

import java.util.Observable;

public class PlayerControler extends Observable {
    public enum Direction {
        LEFT,RIGHT,STOP
    }
    private boolean canFire;
    private int score;
    private int highScore;
    private int lives;
    private Direction direction;
    private int x;
    private int y;


    public PlayerControler(int highScore)  {
        this.highScore = highScore;
        this.score = 0;
        this.canFire = true;
        this.lives = 3;
        this.direction = Direction.STOP;
        this.x = 0;
        this.y = -275;
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
            System.out.println("RIGHT");
            this.x = x + 5;
            setChanged();
            notifyObservers();
        }
        if (this.direction == Direction.LEFT) {
            System.out.println("LEFT");
            this.x = x - 5;
            setChanged();
            notifyObservers();
        }
    }
    public void shootMissile() {

    }
    public void increeseScore(int points) {
        this.score = this.score + points;
        if (this.score > this.highScore) {
            this.highScore = this.score;
        }
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
