public class IceCreamRush {
    public static void bubbleSort(String[] flavors, int[] sales) {
        int n = sales.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                
                if (sales[j] < sales[j + 1]) {
                  
                    int temp = sales[j];
                    sales[j] = sales[j + 1];
                    sales[j + 1] = temp;
                    
                    
                    String tempFlavor = flavors[j];
                    flavors[j] = flavors[j + 1];
                    flavors[j + 1] = tempFlavor;
                    
                    swapped = true;
                }
            }
          
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
   
        String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Mint Chip", "Cookie Dough", "Rocky Road", "Butter Pecan", "Coffee"};
 
        int[] sales = {50, 30, 70, 20, 60, 40, 10, 80};

      
        System.out.println("Original Sales Data:");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println(flavors[i] + ": " + sales[i]);
        }

        bubbleSort(flavors, sales);

        
        System.out.println("\nSorted Sales Data (Descending Order):");
        for (int i = 0; i < flavors.length; i++) {
            System.out.println(flavors[i] + ": " + sales[i]);
        }
    }
}
