package learn.polymorphism;

public class Point1D {
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double length() {
        return Math.abs(x);
    }

    private int x;

}
