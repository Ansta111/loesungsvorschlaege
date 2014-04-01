package de.hhu.propra.blatt3.snake.input;

import de.hhu.propra.blatt3.snake.wurm.WurmController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController implements KeyListener {
    private WurmController wurmController;

    public InputController(WurmController wurmController) {
        this.wurmController = wurmController;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W && wurmController.isCreepingHorizontally()) {
            wurmController.moveUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_A && wurmController.isCreepingVertically()) {
            wurmController.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_S && wurmController.isCreepingHorizontally()) {
            wurmController.moveDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_D && wurmController.isCreepingVertically()) {
            wurmController.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
