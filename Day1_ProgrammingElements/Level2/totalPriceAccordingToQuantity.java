import java.util.Scanner;
public class totalPriceAccordingToQuantity {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the unit Price of the item in (INR): ");
    int unitPrice = sc.nextInt();
    System.out.println("Enter the quantity of the item: ");
    int quantity = sc.nextInt();
    int totalPrice = unitPrice * quantity;
    System.out.println("The total purchases price is INR "+totalPrice+" if the quantity is "+quantity+" and unit price is INR "+unitPrice);
  }

}
