import java.util.Scanner;

public class Coffee_Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;

        while (true) {
            System.out.print("Enter the coffee type (espresso, latte, cappuccino, americano, macchiato) or 'No' to finish: ");
            String coffeeType = sc.nextLine().toLowerCase();

            if (coffeeType.equals("No")) {
                break;
            }

            double price = 0.0;
            if (coffeeType.equals("espresso")) {
                price = 250;
            } else if (coffeeType.equals("latte")) {
                price = 300;
            } else if (coffeeType.equals("cappuccino")) {
                price = 350;
            } else if (coffeeType.equals("americano")) {
                price = 325;
            } else if (coffeeType.equals("macchiato")) {
                price = 400;
            } else {
                System.out.println("Invalid coffee type. Please try again.");
                continue;
            }

            System.out.print("Enter the quantity: ");
            String quantityInput = sc.nextLine();
            int quantity;

            try {
                quantity = Integer.parseInt(quantityInput);
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive integer. Please try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity. Please enter a numeric value.");
                continue;
            }

            double orderCost = price * quantity;
            total += orderCost;
            System.out.printf("The cost for %d %s(s) is rs %.2f.%n", quantity, coffeeType, orderCost);
        }

        double gst = total * 0.18;
        double totalWithGst = total + gst;

        System.out.printf("Total bill before GST: $%.2f%n", total);
        System.out.printf("GST (18%%): $%.2f%n", gst);
        System.out.printf("Total bill after gst : $%.2f%n",totalWithGst);
}
}