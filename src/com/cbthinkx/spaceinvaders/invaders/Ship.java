package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Ship extends Invaders {
    public Ship(BufferedImage f1, int x, int y) {
        super(f1, null, x, y);
        int[] points = {5, 10, 15, 20, 25, 50, 75, 100, 150, 200, 250, 300};
        this.setScore(points[new Random().nextInt(points.length)]);
    }

    @Override
    public void updatePosition() {
        setX(getX() + 4);
        if (getX() > 390) {
            setIsAlive(false);
        }
    }

    @Override
    public void UpdateImage() {
        
    }
}

