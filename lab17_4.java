import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Lab17_4 {
    public static void printHeader(String labName) {
        String cwd = System.getProperty("user.dir");
        String user = System.getProperty("user.name");

        // formatting the datetime as mm-dd-yy @ hh:mm
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter
                formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy @ HH:mm");

        System.out.println("Working Directory: " + cwd);
        System.out.println("Programmer: " + user);
        String labTime = String.format("%s: %s%n", labName,
                                       now.format(formatter));
        System.out.println(labTime);
    }

    public static void main(String[] args) {
        printHeader("Lab 17.4");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your budget for the month: ");
        double budget = sc.nextDouble();
        double sum = 0, input = 0;
        while (input >= 0) {
            System.out.print("Enter an expense, or a negative number to quit: ");
            input = sc.nextDouble();
            if (input > 0) sum += input;
        }
        if (sum == budget) {
            System.out.printf("%s, Good Job! You are on budget", name);
        } else {
            String word = budget - sum > 0 ? "UNDER" : "OVER";
            System.out.printf("%s, you are %s budget by $%,.2f", name, word, Math.abs(budget - sum));
        }
    }
}