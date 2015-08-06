package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JellyFish extends Invaders{
    public JellyFish(BufferedImage f1, BufferedImage f2, int x, int y) {
        super(f1, f2, x, y);
        this.setScore(10);
    }
}
