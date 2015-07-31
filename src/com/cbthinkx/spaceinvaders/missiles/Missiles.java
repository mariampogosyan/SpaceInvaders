package com.cbthinkx.spaceinvaders.missiles;

import java.awt.geom.Rectangle2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Missiles {
	private float speed;
	private boolean isAlive;
	private boolean isDestroyable;
	private double x;
	private double y;
	private Path2D hitbox;
	private ArrayList<BufferedImage> img;
	private Rectangle2D rec;
	public Missiles (double x, double y){
		this.x = x;
		this.y = y; 
		this.rec = new Rectangle2D.Double(x, y, 1, 8);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {  
		this.y = y;
	}
	public Rectangle2D getShape() {
		rec.setRect(x, y, 1, 8);
		return rec;
	}
	public void updatePosition() {
		y = y + 10;		
	}
	public void blowUp() {
		
	}
	public void UpdateImage() {
		
	}
	
}
