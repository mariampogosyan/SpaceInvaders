package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.Observable;

public class Invaders extends Observable {
	private int score;
	private int hitPoints;
	private boolean isAlive;
	private boolean canShoot;
	private int x;
	private int y;
	private int row;
	private BufferedImage frame1;
	private BufferedImage frame2;
	private BufferedImage currentFrame;
	private int frameNum;
	private int count = 0;
	boolean forward=true;
	public Invaders(BufferedImage f1, BufferedImage f2, int x, int y) {
		this.hitPoints = 1;
		this.frame1 = f1;
		this.frame2 = f2;
		this.x = x;
		this.y = y;
		this.frameNum = 0;
		this.isAlive = true;
		this.currentFrame = f1;
	}
	public void updatePosition() {
		if (count != 8 && forward) {
			if (count == 7) {
				moveDown();
			}
			moveRight();
		} else {
			forward = false;
		}
		if (count != 0 && !forward) {
			if (count == 1) {
				moveDown();
			}
			moveLeft();
		 } else {
			 forward = true;
		 }
	}	
	public void moveDown() {
		this.y -=10;
	}
	public void moveRight() {
		count++;
		updateImage();
		this.x += 10;
	}
	public void moveLeft(){
		count--;
		updateImage();
		this.x -= 10;
	}
	public int getRow() {
		return this.row;		
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void blowUp() {
	}
	public void updateImage() {
		if (frameNum == 1) {
			frameNum = 0;
			this.currentFrame = frame1;
		} else {
			frameNum = 1;
			this.currentFrame = frame2;
		}
	}
	public BufferedImage getCurrentFrame() {
		return currentFrame;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public boolean isCanShoot() {
		return canShoot;
	}
	public void setCanShoot(boolean canShoot) {
		this.canShoot = canShoot;
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
}
