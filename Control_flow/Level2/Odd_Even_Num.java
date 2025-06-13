import  java.util.*;
public class Odd_Even_Num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers");
        int num = sc.nextInt();
        System.out.println("Even Numbers: ");
        for(int i = 1;i<=num;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
        System.out.println("Odd Numbers: ");
        for(int i = 1;i<=num;i++){
            if(i%2!=0){
                System.out.println(i);
            }
        }
    }
}
