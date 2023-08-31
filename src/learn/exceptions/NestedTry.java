package learn.exceptions;


public class NestedTry {
    public static void main(String[] args) {
        String[] numbers = {"76", "0", "Y-", "33"};
        int result;
        int sum = 0;
        for (String number: numbers) {
            try {
                result = Integer.parseInt(number);
                try {
                    sum += 100/result;
                } catch (ArithmeticException e) {
                    System.err.println(e);
                }
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }
        System.out.println(sum);
    }
}
