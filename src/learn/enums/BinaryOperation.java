package learn.enums;

public enum BinaryOperation {
    PLUS ("+") {
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS ("-") {
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    DIVISION ("/") {
        public int calculate(int a, int b){
            return a / b;
        }
    },
    MULT ("*") {
        public int calculate(int a, int b){
            return a * b;
        }
    };

    private String operation;

    public abstract int calculate(int a, int b);

    BinaryOperation(String operation) {
        this.operation = operation;
    }

    public static void main(String args[]) {
        int x = 10;
        int y = 2;
        for (BinaryOperation op : BinaryOperation.values())
            System.out.println(x + " " + op.operation + " " + y
                    + " = " + op.calculate(x, y));
    }
}
