package de.hhu.propra.blatt2;

import java.time.LocalDate;

public class Datum {
    final int year;
    final int month;
    final int day;

    public Datum(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapyear() {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public boolean istVor(Datum datum) {
        return datum.year > year ||
                (datum.year == year && (datum.month > month || (datum.month == month && datum.day > day)));
    }

    public boolean istNach(Datum datum) {
        return datum.year < year ||
                (datum.year == year && (datum.month < month || (datum.month == month && datum.day < day)));
    }

    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    public Datum tageVorher(int tage) {
        LocalDate d = LocalDate.of(year, month, day);
        LocalDate newdate = d.minusDays(tage);
        return new Datum(newdate.getYear(), newdate.getMonthValue(), newdate.getDayOfMonth());
    }

    public static void main(String[] args) {
        Datum d1 = new Datum(2004, 12, 12);
        Datum d2 = new Datum(2000, 1, 24);
        Datum d3 = new Datum(1900, 1, 24);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

        System.out.println(d1.isLeapyear());
        System.out.println(d2.isLeapyear());
        System.out.println(d3.isLeapyear());
        System.out.println(d3.istVor(d2));
        System.out.println(d3.istNach(d1));

        System.out.println(d1.tageVorher(400));
    }
}
