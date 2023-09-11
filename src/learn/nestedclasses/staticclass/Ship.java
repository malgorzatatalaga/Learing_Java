package learn.nestedclasses.staticclass;

class Ship {
    public int x = 10;
    private static int y = 10;
    public static class Boat {
        public void test() {
            /*
              A static nested class can use the fields and methods of an instance of its enclosing class
              only through a reference to its object.
             */
            Ship sh = new Ship();
            sh.x = 20;
            /*
            A static nested class has direct access only to the static fields and methods of its enclosing class.
             */
            y = 20;
        }
    }
}
