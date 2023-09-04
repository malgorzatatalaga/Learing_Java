package learn.nestedclasses.localclass;

class Test {
    /**
     * A local class has access to local variables of the enclosing block that are declared as final
     * (for Java 7 and earlier) and effectively final (for Java 8 and later).
     */
    private int x = 10;
    void work() {
        //The variable y is of the effectively final type since its value does not change in the method
        int y = 10;
        class LocalClass {
            public void test() {
                x = 20;
                System.out.println(x + " " + y);
            }
        }
    }
}
