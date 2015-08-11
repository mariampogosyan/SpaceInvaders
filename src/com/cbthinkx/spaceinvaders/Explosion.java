package com.cbthinkx.spaceinvaders;

import java.awt.image.BufferedImage;

public class Explosion {
    private int x;
    private int y;
    private int time;
    private BufferedImage explode;

    public Explosion(int x, int y, BufferedImage explode) {
        this.x = x;
        this.y = y;
        this.time = 10;
        this.explode = explode;
    }
    public boolean canDraw() {
        time--;
        if (time > 0) {
            return true;
        } else {
            return false;
        }
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public BufferedImage getExplode() {
        return explode;
    }
    public void setExplode(BufferedImage explode) {
        this.explode = explode;
    }
}
