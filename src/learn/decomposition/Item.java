package learn.decomposition;

public record Item(int itemId, String name) {
    //The keyword record provides one more mechanism for creating a class with immutable instances.

    /*
    This record guarantees immutability of the values in the record fields and eliminates the need to create a constructor,
    methods equals(Object), hashCode(), and toString(), which are generated automatically for the record.
    Instead of getters, methods with a field name are generated—in this case, name() and itemId().
     */
}
