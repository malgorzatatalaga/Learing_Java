import java.util.Scanner;

public class ElectronicWatch {
    /*
    The program must print an electronic watch screen output for a given value of seconds since midnight.
    Output format is h:mm:ss.
    Extra challenge: try to solve the task without using if statements or cycles.
     */
    public void displayTime() {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hours = (seconds / 3600) >= 24 ? seconds / 3600 - 24 : seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        String formattedTime = String.format("%d:%02d:%02d", hours, minutes, remainingSeconds);
        System.out.println(formattedTime);
    }
}
