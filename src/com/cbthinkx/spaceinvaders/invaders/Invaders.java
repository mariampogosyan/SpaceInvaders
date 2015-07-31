package com.cbthinkx.spaceinvaders.invaders;

import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Invaders {
	private int score;
	private int hitPoints;
	private boolean isAlive;
	private boolean canShoot;
	private int x;
	private int y;
	private int row;
	private ArrayList<BufferedImage> img;
	private BufferedImage currentFrame;
	private int frameNum;

	public Invaders(ArrayList<BufferedImage> img, int x, int y) {
		this.hitPoints = 1;
		this.img = img;
		this.x = x;
		this.y = y;
		this.frameNum = 0;
		this.isAlive = true;
		this.currentFrame = img.get(frameNum);
	}
	public void updatePosition() {
	}
	public void blowUp() {

	}
	public void UpdateImage() {
		if (frameNum == 1) frameNum = 0;
		if (frameNum == 0) frameNum = 1;
		this.currentFrame = img.get(frameNum);
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
