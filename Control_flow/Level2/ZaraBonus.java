import  java.util.*;
public class ZaraBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary : ");
        int salary = sc.nextInt();
        System.out.println("Enter the work Years :");
        int year = sc.nextInt();
        int bonusAmount = 0;
        if(year > 5){
            bonusAmount += (5*salary) /100;
            System.out.println("The Bonus Amount is : "+ bonusAmount);
        }
    }
}
