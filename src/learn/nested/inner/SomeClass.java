package learn.nested.inner;

public class SomeClass {
    /**
     * creating an inner class instance outside its outer class
     * 1.
     */
    Demo.Engine engine = new Demo().new Engine();

    /**
     * 2.
     */
    Demo demo = new Demo();
    Demo.Engine eng = demo.new Engine();
}
