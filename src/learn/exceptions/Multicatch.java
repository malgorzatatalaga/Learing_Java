package learn.exceptions;

public class Multicatch {
    public static void main(String[] args) {
        String[] numbers = {"76", "0", "Y-", "33"};
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += 100 / Integer.parseInt(number);
            } catch (ArithmeticException | NumberFormatException e) {
                System.err.println(e);
            }
        }
        System.out.println(sum);
    }
}
