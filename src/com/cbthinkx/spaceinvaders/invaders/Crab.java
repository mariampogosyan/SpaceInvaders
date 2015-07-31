package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Crab extends Invaders{
    public Crab(ArrayList<BufferedImage> img, int x, int y) {
        super(img, x, y);
        this.setScore(20);
    }
}
