package de.hhu.propra.blatt3.wurm1a;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WurmImpl implements Wurm, ActionListener, AutoCloseable {
    private static final int REFILL = 1;
    private static final int INTERVALL = 300;
    private final Timer manaRefiller;
    private int mana;

    public WurmImpl() {
        manaRefiller = new Timer(INTERVALL, this);
        manaRefiller.start();
    }

    @Override
    public synchronized int spell(MagicObject mo) {
        if (mana - mo.getManaCost() >= 0) {
            mana -= mo.getManaCost();
            return mo.getDamage();
        }
        return 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mana += REFILL;
    }

    @Override
    public void close() throws Exception {
        manaRefiller.stop();
    }
}
