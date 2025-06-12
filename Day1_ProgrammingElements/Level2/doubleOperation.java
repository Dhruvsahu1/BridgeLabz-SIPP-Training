import java.util.Scanner;
public class doubleOperation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of a");
        double a = sc.nextDouble();
        System.out.println("enter the value of b");

        double b = sc.nextDouble();
        System.out.println("enter the value of c");

        double c = sc.nextDouble();

        double res1 = a+b*c;
        double res2 = a*b+c;
        double res3 = c+a/b;
        double res4 = a%b+c;

        System.out.println("The result of double operations are "+ res1 + ", " + res2 + ", " + res3 + "and  " + res4);
    }
}


