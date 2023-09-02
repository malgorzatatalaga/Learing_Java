package learn.exceptions.custom;

public class MarkException extends Exception {
    @Override
    public String getMessage() {
        return "Unacceptable value!";
    }
}
