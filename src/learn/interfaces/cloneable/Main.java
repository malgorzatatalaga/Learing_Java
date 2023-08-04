package learn.interfaces.cloneable;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //shallow cloning with the cloneable interface
        try {
            cloneAnObj();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cloneAnObj() throws CloneNotSupportedException {
        Date dd = new Date( System.currentTimeMillis() );
        Student stud1 = new Student(dd, 201);
        System.out.println(stud1);
        Student stud2 = (Student) stud1.clone(); //casting the reference to Student, since the clone()
        //method returns an Object
        System.out.println(stud2);
    }
}
