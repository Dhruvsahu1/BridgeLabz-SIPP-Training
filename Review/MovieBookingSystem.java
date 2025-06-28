import java.util.Scanner;

public class MovieBookingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueBooking = true;
        int priceSnack = 0;
        int price = 0;
        while (continueBooking) {
            System.out.println("Welcome to the Movie Booking System!");
            System.out.println("Please choose your seat type:");
            System.out.println("1. Gold");
            System.out.println("2. Silver");
            System.out.println("3. Bronze");

            int seatChoice = scanner.nextInt();
            scanner.nextLine(); 

            String seatType = "";
            switch (seatChoice) {
                case 1:
                    seatType = "Gold";
                    price = 1000;

                    break;
                case 2:
                    seatType = "Silver";
                    price = 500;
                    break;
                case 3:
                    seatType = "Bronze";
                    price = 300;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid seat type.");
                    continue;
            }

            System.out.println("You have selected a " + seatType + " seat.");

            System.out.println("Would you like to order snacks enter  (yes/no)");
            String snackChoice = scanner.nextLine().toLowerCase();

            if (snackChoice.equals("yes")) {
                System.out.println("Please choose your snack:");
                System.out.println("1. Popcorn");
                System.out.println("2. Soda");
                System.out.println("3. Chips");

                int snackOption = scanner.nextInt();
                scanner.nextLine();

                String snack = "";
                
                switch (snackOption) {
                    case 1:
                        snack = "Popcorn";
                        priceSnack = 100;
                        break;
                    case 2:
                        snack = "Soda";
                        priceSnack = 30;
                        break;
                    case 3:
                        snack = "Chips";
                        priceSnack = 50;
                        break;
                    default:
                        System.out.println("Invalid choice. No snack will be added.");
                        snack = "None";
                }

                System.out.println("You have ordered " + snack + ".");
            } else if (!snackChoice.equals("no")) {
                System.out.println("Invalid choice. No snack will be added.");
            }

            System.out.println("Would you like to make another booking enter (yes/no)");
            String bookingChoice = scanner.nextLine().toLowerCase();

            if (!bookingChoice.equals("yes")) {
                continueBooking = false;
                System.out.println("Your total order is "+ (price+priceSnack));
                System.out.println("Thank you for using the Movie Booking System.");
            }
        }

    }
}
