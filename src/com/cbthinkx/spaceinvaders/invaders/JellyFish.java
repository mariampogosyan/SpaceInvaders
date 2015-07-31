package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JellyFish extends Invaders{
    public JellyFish(ArrayList<BufferedImage> img, int x, int y) {
        super(img, x, y);
        this.setScore(10);
    }
}
