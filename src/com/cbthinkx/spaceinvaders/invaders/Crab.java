package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Crab extends Invaders{
    public Crab(BufferedImage f1, BufferedImage f2, int x, int y) {
        super(f1, f2, x, y);
        this.setScore(20);
    }
}
