package learn.exceptions;

public class TwistInTaleCatchError  {
    public static void main(String[] args)  {
        try  {
            method();
        }  catch (StackOverflowError e)  {
            for (int i=0; i<2; ++i)
                System.out.println(i);
        }
    }
    public static void method() {
        method();
    }
}
