import java.util.Scanner;
public class QuotientAndReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number");
        int num1 = sc.nextInt();
        System.out.println("enter the second number");
        int num2 = sc.nextInt();
        int reminder = num1%num2;
        int quotient = num1/num2;
        System.out.println("The quotient is "+ quotient + " and reminder  is "+ reminder +" of two number "+ num1 +" and "+ num2);
    }
}
