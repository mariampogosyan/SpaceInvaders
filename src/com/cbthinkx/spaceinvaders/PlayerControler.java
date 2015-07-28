package com.cbthinkx.spaceinvaders;

public class PlayerControler {
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


    public PlayerControler(int highScore) {
        this.highScore = highScore;
        this.score = 0;
        this.canFire = true;
        this.lives = 3;
        this.direction = Direction.STOP;
//        this.x = middle of screen
//        this.y =
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
    }
    public void shootMissile() {

    }
    public void updatePosition() {
        if (this.direction == Direction.LEFT) {

        }
        if (this.direction == Direction.RIGHT) {

        }
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
}
