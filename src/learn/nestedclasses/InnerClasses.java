package learn.nestedclasses;

class InnerClasses {
    //creating an object of an inner class outside its outer class
    Ship ship = new Ship();
    Ship.Engine engine = ship.new Engine();
    class Ship {
        //invoking elements of inner and outer classes
        private int x = 10;
        protected class Engine {
            public void test() {
                //invoking the field of an outer class's instance directly
                x = 20;
            }
        }
        public void testing() {
            Engine eng = new Engine();
            //invoking the method of an outer class's instance through an object
            eng.test();
        }
    }
}
