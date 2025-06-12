import java.util.Scanner;
public class intOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of a");
        int a = sc.nextInt();
        System.out.println("enter the value of b");

        int b = sc.nextInt();
        System.out.println("enter the value of c");

        int c = sc.nextInt();

        int res1 = a+b*c;
        int res2 = a*b+c;
        int res3 = c+a/b;
        int res4 = a%b+c;

        System.out.println("The result of int operations are "+ res1 + ", " + res2 + ", " + res3 + "and  " + res4);
    }
}
