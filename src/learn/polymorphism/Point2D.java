package learn.polymorphism;

public class Point2D extends Point1D {
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double length() {
        return Math.hypot(getX(), y);
    }

    private int y;

}
