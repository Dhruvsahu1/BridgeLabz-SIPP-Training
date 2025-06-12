import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

    
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division =  number1 / number2 ;
        System.out.printf(
            "The addition, subtraction, multiplication and division value of the numbers %.2f and %.2f is:\n",
            number1, number2
        );
        System.out.printf("Addition: %.2f\n", addition);
        System.out.printf("Subtraction: %.2f\n", subtraction);
        System.out.printf("Multiplication: %.2f\n", multiplication);
        System.out.printf("Division: %.2f\n", division);

        
    }
}
