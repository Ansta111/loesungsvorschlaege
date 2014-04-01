package de.hhu.propra.blatt3.snake.wurm;

import de.hhu.propra.blatt3.snake.field.Field;
import de.hhu.propra.blatt3.snake.coin.CoinController;

import java.awt.Point;
import java.util.List;

public class WurmController {
    private Wurm wurm;
    private Field field;
    private CoinController coinController;

    private String text = null;
    private long textTime = 0;

    public void Say(String text) {
        this.text = text;
        textTime = System.currentTimeMillis();
    }

    public String getText() {
        if(System.currentTimeMillis() - textTime < 2000) {
            return text;
        } else {
            return null;
        }
    }

    public WurmController(Wurm wurm, Field field, CoinController coinController) {
        this.wurm = wurm;
        this.field = field;
        this.coinController = coinController;
    }

    private boolean hasAteCoin() {
        return getCurrentPlace().equals(coinController.getPosition());
    }

    public boolean isCreepingVertically() {
        return wurm.getDirection() == Wurm.Direction.North ||
                wurm.getDirection() == Wurm.Direction.South;
    }

    public boolean isCreepingHorizontally() {
        return wurm.getDirection() == Wurm.Direction.West ||
                wurm.getDirection() == Wurm.Direction.East;
    }

    public boolean isBlocked() {
        return wurm.isBlocked();
    }

    public void moveWurm() {
        wurm.move();

        if(hasAteCoin()) {
            int coinValue = coinController.getValueAndCreateNewCoin();
            wurm.eatCoin(coinValue);
            Say("+" + coinValue);
        }
    }

    public Point getCurrentPlace() {
        return wurm.getCurrentPlace();
    }

    public List<Point> getTail() { return wurm.getTail(); }

    public List<Point> getPath() {
        return wurm.getPath();
    }

    public int getW() {
        return field.getW();
    }

    public int getH() {
        return field.getH();
    }

    public void moveDown() {
        wurm.moveDown();
    }

    public void moveUp() {
        wurm.moveUp();
    }

    public void moveLeft() {
        wurm.moveLeft();
    }

    public void moveRight() {
        wurm.moveRight();
    }
}
