package classes;

public class Initialization {
    //Initialization of final Fields
    private final int XX = 50; //In the same line where it is declared
    private final int ZZ;
    private final int YY; //In one of the dynamic initializers
    {
        //called before constructors
        ZZ = 20;
        System.out.println("Dynamic section");
    }
    public Initialization() {
        //In each constructor
        YY = 30;
        System.out.println("Constructor");
    }

    public static void main(String[] arg) {
        System.out.println("Main");
        Initialization init = new Initialization();
    }
}
