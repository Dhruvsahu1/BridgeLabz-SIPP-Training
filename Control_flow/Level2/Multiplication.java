import java.util.*;
public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n  = sc.nextInt();
        if(n>5 && n<10){
            for(int i = 1;i<11;i++){
                System.out.println(n +" * "+ i+" = "+n*i);
            }
        }
    }
}
