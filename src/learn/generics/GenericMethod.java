package learn.generics;

public class GenericMethod {
    public static <T> byte asByte(T num) {
        if (num instanceof Number) {
            return ((Number) num).byteValue();
        }
        return 0;
    }
}
