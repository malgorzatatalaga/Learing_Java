package learn.polymorphism;

public class Main {
    public static void main(String[] args) {
        Point1D point1 = new Point1D();
        Point1D point2 = new Point2D();
        point1.setX(3);
        System.out.println(point1.length());
        ((Point2D) point2).setY(4);
        System.out.println(point2.length());
    }
}
