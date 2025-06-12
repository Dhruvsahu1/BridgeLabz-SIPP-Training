import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

   
        double totalInches = heightCm / 2.54;

      
        int feet = (int)(totalInches / 12);
        double inches = totalInches % 12;

     
        System.out.printf("Your height in cm is %.2f, in feet is %d, and in inches is %.2f\n", heightCm, feet, inches);

       
    }
}
