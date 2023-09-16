package learn.generics.wildcard;

public class Wildcard<T extends Number> {

    private T x;
    private T y;

    public Wildcard(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public int performAddition() {
        return (int)(x.doubleValue() + y.doubleValue());
    }

    public boolean equals(Wildcard<?> wildcard) {
        return this.performAddition() == wildcard.performAddition();
    }
}
