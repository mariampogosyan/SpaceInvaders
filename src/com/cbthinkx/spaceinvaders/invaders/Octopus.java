package com.cbthinkx.spaceinvaders.invaders;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Octopus extends Invaders{
    public Octopus(BufferedImage f1, BufferedImage f2, int x, int y) {
        super(f1, f2, x, y);
        this.setScore(30);
    }
}
