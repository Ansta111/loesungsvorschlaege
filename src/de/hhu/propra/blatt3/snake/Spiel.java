package de.hhu.propra.blatt3.snake;

import de.hhu.propra.StdDraw;
import de.hhu.propra.blatt3.snake.field.Field;
import de.hhu.propra.blatt3.snake.wurm.Wurm;
import de.hhu.propra.blatt3.snake.wurm.WurmController;
import de.hhu.propra.blatt3.snake.coin.CoinController;
import de.hhu.propra.blatt3.snake.printer.WurmPrinter;
import de.hhu.propra.blatt3.snake.printer.GfxWurmPrinter;
import de.hhu.propra.blatt3.snake.input.InputController;

public class Spiel {
    private static final int w = 10;
    private static final int h = 10;
    public static void main(String[] args) {
        Field field = new Field(w, h);
        Wurm wurm = new Wurm(field);
        CoinController coinController = new CoinController(field);
        WurmController wurmController = new WurmController(wurm, field, coinController);
        WurmPrinter gfxPrinter = new GfxWurmPrinter(wurmController, coinController);

        InputController inputController = new InputController(wurmController);
        StdDraw.addKeyListener(inputController);

        if (args.length == 0) {
            gfxPrinter.print();
        }
    }

}
