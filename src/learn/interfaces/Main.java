package learn.interfaces;

public class Main {
    public static void main(String[] args) {
        SomeClass obj = new SomeClass();
        System.out.println(obj.someMethod());
        System.out.println(((Interface2) obj).someMethod());
        //different calls to one field:
        System.out.println(((Interface1) obj).someField);
        System.out.println(Interface1.someField);
    }
}

