package projects.abstractclass;

import java.util.List;

class Quadrilateral extends Figure {

    private final double ax;
    private final double ay;
    private final double bx;
    private final double by;
    private final double cx;
    private final double cy;
    private final double dx;
    private final double dy;
    private final List<Point> points;

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.ax = pointA.getX();
        this.ay = pointA.getY();
        this.bx = pointB.getX();
        this.by = pointB.getY();
        this.cx = pointC.getX();
        this.cy = pointC.getY();
        this.dx = pointD.getX();
        this.dy = pointD.getY();
        points = List.of(pointA, pointB, pointC, pointD);
    }

    @Override
    public double area() {
        double triangleADC = 0.5 * Math.abs(ax * (dy - cy) + dx * (cy - ay) + cx * (ay - dy));
        double triangleABC = 0.5 * Math.abs(ax * (by - cy) + bx * (cy - ay) + cx * (ay - by));
        return triangleABC + triangleADC;
    }

    @Override
    public String toString() {
        return String.format("Quadrilateral[%s]", pointsToString());
    }

    @Override
    public String pointsToString() {
        return "(" + ax + "," + ay + ")(" + bx + "," + by + ")(" + cx + "," + cy + ")(" +
                dx + "," + dy + ")";
    }

    @Override
    public Point leftmostPoint() {
        double minX = Math.min(Math.min(Math.min(ax, bx), cx), dx);
        for (Point point : points) {
            if (point.getX() == minX) {
                return point;
            }
        }
        return null;
    }
}

