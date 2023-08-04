package learn.interfaces.cloneable;

import java.util.Date;

public class CloneableMain {
    public static void main(String[] args) {
        try {
            cloneAnObj();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cloneAnObj() throws CloneNotSupportedException {
        //shallow cloning with the cloneable interface
        Date dd = new Date(System.currentTimeMillis());
        Student stud1 = new Student(dd, 201);
        System.out.println(stud1);
        Student stud2 = (Student) stud1.clone(); //casting the reference to Student, since the clone()
        //method returns an Object
        System.out.println(stud2);

        //deep cloning with the cloneable interface
        Scholar scholar1 = new Scholar(dd, 201);
        System.out.println(scholar1);
        Scholar scholar2 = (Scholar) scholar1.clone();
        System.out.println(scholar2);
        
    }
}
