package learn.nested.anonymous;

public class AnonymousClass {
    /**
     * An anonymous class is a class without a name.
     * In addition, if it is necessary to create a sole class object, there is no need to assign a name to this class.
     */
    private int x = 10;
    void doJob() {
        final int y = 20;
        //The anonymous class is declared as implementation of the CustomTest interface.
        CustomTest  tst = new CustomTest() {
            private int z = 10;
            { System.out.println("Init block"); }
            //Methods declared in an anonymous class cannot be accessed from outside.
            public void test() {
                System.out.println(x + " " +  z + " " + y );
            }
        };
        tst.test();
    }

    public static void main(String[] args) {
        AnonymousClass anonymousClass = new AnonymousClass();
        anonymousClass.doJob();
    }
}
