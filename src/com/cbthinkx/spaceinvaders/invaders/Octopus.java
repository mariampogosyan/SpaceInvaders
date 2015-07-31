package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Octopus extends Invaders{
    public Octopus(ArrayList<BufferedImage> img, int x, int y) {
        super(img, x, y);
        this.setScore(30);
    }
}
