package projects.abstractclass;

import java.util.List;

class Triangle extends Figure {

    private final double ax;
    private final double ay;
    private final double bx;
    private final double by;
    private final double cx;
    private final double cy;
    private final List<Point> points;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.ax = pointA.getX();
        this.ay = pointA.getY();
        this.bx = pointB.getX();
        this.by = pointB.getY();
        this.cx = pointC.getX();
        this.cy = pointC.getY();
        points = List.of(pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return String.format("Triangle[%s]", pointsToString());
    }

    @Override
    public double area() {
        return 0.5 * Math.abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by));
    }

    @Override
    public String pointsToString() {
        return "(" + ax + "," + ay + ")(" + bx + "," + by + ")(" + cx + "," + cy + ")";
    }

    @Override
    public Point leftmostPoint() {
        double minX = Math.min(Math.min(ax, bx), cx);
        for (Point point : points) {
            if (point.getX() == minX) {
                return point;
            }
        }
        return null;
    }
}

