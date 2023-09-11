package learn.enums;

public enum Operation {
    /**
     * An enumeration can contain abstract methods.
     * In this case, each constant must implement all abstract methods using anonymous classes.
     */
    PLUS {
        double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDED_BY {
        double eval(double x, double y) {
            return x / y;
        }
    };

    abstract double eval(double x, double y);

    public static void main(String[] args) {
        double x = 2.0;
        double y = 4.0;
        for (Operation op : Operation.values())
            System.out.println(x + " " + op + " " + y
                    + " = " + op.eval(x, y));
    }
}

