public class profitAndLoss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit  = sellingPrice - costPrice;
        double profitPercentage = ((double)profit / costPrice) * 100;

        System.out.printf("The cost Price is INR %d and selling price is INR %d\nThe profit is INR %d and the profit percentage is %.2f %%\n",
            costPrice, sellingPrice, profit, profitPercentage
        );
    }
}
