package learn.interfaces;

public class SomeClass implements Interface1, Interface2 {

    //common implementation of the interfaces' method
    @Override
    public String someMethod() {
        System.out.println("In interface2 = " + Interface2.someField);
        return "It Works";
    }
}
