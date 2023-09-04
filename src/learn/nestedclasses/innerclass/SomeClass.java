package learn.nestedclasses.innerclass;

public class SomeClass {
    /**
     * creating an inner class instance outside its outer class
     * 1.
     */
    Ship.Engine engine = new Ship().new Engine();

    /**
     * 2.
     */
    Ship ship = new Ship();
    Ship.Engine eng = ship.new Engine();
}
