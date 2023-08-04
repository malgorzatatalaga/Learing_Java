package learn.decomposition;

public class ItemMain {
    public static void main(String[] args) {
        Item i1 = new Item(77, "A");
        //getter
        System.out.println(i1.itemId() + " " + i1.name());
        //toString()
        System.out.println(i1);
        //equals()
        Item i2 = new Item(77, "A");
        System.out.println(i1.equals(i2));
        //hashCode()
        System.out.println(i1.hashCode() == i2.hashCode());
    }
}
