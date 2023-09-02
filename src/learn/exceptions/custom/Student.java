package learn.exceptions.custom;

public class Student {
    private String firstName;
    private final int group;
    private double mark;
    public Student(String firstName, int group) {
        this.firstName = firstName;
        this.group = group;
    }
    public void setMark(double mark) throws MarkException {
        if (mark < 0 || mark > 100) {
            throw new MarkException();
        }
        this.mark = mark;
    }
}
