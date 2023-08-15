package projects.abstractclass;

class Circle extends Figure {

    private final double x;
    private final double y;
    private final double radius;

    public Circle(Point point, double radius) {
        this.x = point.getX();
        this.y = point.getY();
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle[" + pointsToString() + radius + "]";
    }

    @Override
    public double area() {
        double PI = Math.PI;
        return PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(x - radius, y);
    }
}

