package de.hhu.propra.blatt3.snake.printer;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt3.snake.coin.CoinController;
import de.hhu.propra.blatt3.snake.wurm.WurmController;

import javax.swing.Timer;
import java.awt.Color;
import java.awt.Point;

public class GfxWurmPrinter implements WurmPrinter {
    private WurmController wurmController;
    private CoinController coinController;

    public GfxWurmPrinter(WurmController wurmController, CoinController coinController) {
        this.wurmController = wurmController;
        this.coinController = coinController;
    }

    @Override
    public void print() {
        new Timer(300, (e) -> {
            StdDraw.show();
            StdDraw.clear();
            if (wurmController.isBlocked()) {
                wurmController.Say("GAME OVER!");
            } else {
                wurmController.moveWurm();
            }
            printCoin();
            printTail();
            printWurm();
            printWurmText();
        }).start();
    }

    private void printWurmText() {
        if (wurmController.getText() != null) {
            Color pen = StdDraw.getPenColor();
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(0.5, 0.9, wurmController.getText());
            StdDraw.setPenColor(pen);
        }
    }

    private void printCoin() {
        StdDraw.picture(coinController.getPosition().x / (double) wurmController.getW() + 0.1,
                        coinController.getPosition().y / (double) wurmController.getH() + 0.1, "res/coin.png");
    }

    private void printTail() {
        for (Point p : wurmController.getTail()) {
            StdDraw.filledCircle(p.x / (double) wurmController.getW() + 0.1, p.y / (double) wurmController.getH() + 0.1,
                                 0.03);
        }
    }

    private void printWurm() {
        StdDraw.picture(wurmController.getCurrentPlace().x / (double) wurmController.getW() + 0.1,
                        wurmController.getCurrentPlace().y / (double) wurmController.getH() + 0.1, "res/wurm.png");
    }
}
