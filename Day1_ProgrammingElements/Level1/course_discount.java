public class course_discount {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;
        int discount = (fee *10)/100;
        int discountedAmount = fee - discount;
        System.out.println("The discount amount is INR "+discount+" and the final discounted fee is INR "+discountedAmount);
    }
}
