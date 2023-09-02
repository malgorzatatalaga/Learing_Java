package learn.exceptions.custom;

public class Main {
    public static void main(String[] args) {
        Student stud = new Student("Ivan", 505);
        try {
            stud.setMark(101);
        } catch (MarkException ee) {
            System.err.println( ee.getMessage() );
        }
    }
}
