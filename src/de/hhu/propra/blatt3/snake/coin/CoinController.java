package de.hhu.propra.blatt3.snake.coin;

import de.hhu.propra.blatt3.snake.field.Field;

import java.awt.Point;

public class CoinController {
    private Field field;
    private Coin coin;

    public CoinController(Field field) {
        this.field = field;
        this.coin = createNewCoin();
    }

    private Coin createNewCoin() {
        return new Coin(field);
    }

    public Point getPosition() {
        return coin.getPosition();
    }

    public int getValueAndCreateNewCoin() {
        int oldCoinValue = coin.getValue();
        coin = createNewCoin();
        return oldCoinValue;
    }
}
