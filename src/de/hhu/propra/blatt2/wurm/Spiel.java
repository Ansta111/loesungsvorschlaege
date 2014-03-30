package de.hhu.propra.blatt2.wurm;

import de.hhu.propra.blatt2.wurm.printer.ConsoleWurmPrinter;
import de.hhu.propra.blatt3.wurm.printer.GfxWurmPrinter;
import de.hhu.propra.blatt2.wurm.printer.WurmPrinter;

public class Spiel {
    private static final int w = 10;
    private static final int h = 10;
    public static void main(String[] args) {
        Wurm wurm = new Wurm(new Field(w, h));
        WurmPrinter consolePrinter = new ConsoleWurmPrinter(wurm);
        WurmPrinter gfxPrinter = new GfxWurmPrinter(wurm);


        if (args.length == 0) {
            gfxPrinter.print();
        } else if (args[0].equals("console")) {
            consolePrinter.print();
        }
    }

}
