package com.cbthinkx.spaceinvaders;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Robert on 7/29/15.
 */
public class SpaceInvadersKeyEventDispatcher implements KeyEventDispatcher {
    private GameModel model;
    private GameView view;

    public SpaceInvadersKeyEventDispatcher(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

        if (e.getID() == KeyEvent.KEY_PRESSED || e.getID() == KeyEvent.KEY_RELEASED) {
            int eKeyCode = e.getKeyCode();
            if (eKeyCode == KeyEvent.VK_UP || eKeyCode == KeyEvent.VK_LEFT || eKeyCode == KeyEvent.VK_DOWN || eKeyCode == KeyEvent.VK_RIGHT || eKeyCode == KeyEvent.VK_SPACE) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().redispatchEvent(this.view, e);
                return true;
            }
        }
        return false;
    }
}
