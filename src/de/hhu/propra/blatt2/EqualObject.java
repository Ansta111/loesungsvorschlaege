package de.hhu.propra.blatt2;

public class EqualObject {
    private final String id;

    public EqualObject(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(((EqualObject) obj).getId());
    }

    public static void main(String[] args) {
        EqualObject o1 = new EqualObject("eins");
        EqualObject o1a = new EqualObject("eins");
        EqualObject o2 = new EqualObject("zwei");

        System.out.println(o1.equals(o1a));
        System.out.println(o1.equals(o2));
    }

    public String getId() {
        return id;
    }
}
