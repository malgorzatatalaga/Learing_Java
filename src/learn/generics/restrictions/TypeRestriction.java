package learn.generics.restrictions;

public class TypeRestriction <T extends Number> {
    private T x;
    private T y;

    public TypeRestriction(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public int performCalculation() {
        return (int)(x.doubleValue() / y.doubleValue());
    }
}
