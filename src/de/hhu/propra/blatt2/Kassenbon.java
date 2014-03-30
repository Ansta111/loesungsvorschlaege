package de.hhu.propra.blatt2;

import java.util.ArrayList;
import java.util.List;

public class Kassenbon implements IKassenbon {
    private static class KassenBonItem {
        String name;
        int anzahl;
        double preis;

        public KassenBonItem(String name, int anzahl, double preis) {
            this.name = name;
            this.anzahl = anzahl;
            this.preis = preis;
        }
    }

    List<KassenBonItem> items = new ArrayList<>();

    @Override
    public int anzahlArtikel() {
        int anzahl = 0;
        for (KassenBonItem item : items) {
            anzahl += item.anzahl;
        }
        return anzahl;
    }

    @Override
    public double gesamtPreis() {
        double preis = 0;
        for (KassenBonItem item : items) {
            preis += item.anzahl * item.preis;
        }
        return preis;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (KassenBonItem item : items) {
            sb.append(String.format("%s - %sx %s € (%s €)\n", item.name, item.anzahl, item.preis, item.anzahl * item.preis));
        }
        return sb.toString();
    }

    public void addItem(KassenBonItem item) {
        items.add(item);
    }

    public static void main(String[] args) {
        Kassenbon kassenbon = new Kassenbon();
        kassenbon.addItem(new KassenBonItem("Wurst", 3, 3.5));
        kassenbon.addItem(new KassenBonItem("Käse", 4, 1.5));
        kassenbon.addItem(new KassenBonItem("Wasser", 6, 0.19));

        System.out.println(kassenbon);
        System.out.println(kassenbon.anzahlArtikel());
        System.out.println(kassenbon.gesamtPreis());
    }
}
