import java.util.Scanner;

/**
 * Created by Max on 20.11.16.
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number:");
        int number1 = scanner.nextInt();

        System.out.println("Please enter the second number:");
        int number2 = scanner.nextInt();

        System.out.println("Please enter the operator (+, -, *, /):");
        String operator = scanner.next();

        int result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            default:
                System.out.println("Could not parse operator!");
                return;
        }

        System.out.println("Your calculation is: " + number1 + " " + operator + " " + number2 + " = " + result);
    }
}
