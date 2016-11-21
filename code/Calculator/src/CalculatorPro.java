import java.util.Scanner;

/**
 * Created by Max on 21.11.16.
 */
public class CalculatorPro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first number:");

        int result = scanner.nextInt();
        System.out.println("Please enter the operator (+, -, *, /) or 'stop' to finish:");
        String operator = scanner.next();

        while (!operator.equals("stop")) {
            System.out.println("Please enter the next number:");
            int number = scanner.nextInt();

            switch (operator) {
                case "+":
                    result = result + number;
                    break;
                case "-":
                    result = result - number;
                    break;
                case "*":
                    result = result * number;
                    break;
                case "/":
                    result = result / number;
                    break;
                default:
                    System.out.println("Could not parse operator!");
                    return;
            }

            System.out.println("Your interim result is: " + result);
            System.out.println("Please enter the next operator (+, -, *, /) or 'stop' to finish:");
            operator = scanner.next();
        }

        System.out.println("Your result is: " + result);
    }

}
