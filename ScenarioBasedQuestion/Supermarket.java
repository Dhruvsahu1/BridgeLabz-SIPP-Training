import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Customer {
    private LinkedList<String> items;

    public Customer() {
        this.items = new LinkedList<>();
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public LinkedList<String> getItems() {
        return items;
    }
}

class Supermarket {
    private Queue<Customer> checkoutQueue;
    private HashMap<String, Double> itemPrices;
    private HashMap<String, Integer> itemStock;

    public Supermarket() {
        this.checkoutQueue = new LinkedList<>();
        this.itemPrices = new HashMap<>();
        this.itemStock = new HashMap<>();

        itemPrices.put("Apple", 0.5);
        itemPrices.put("Banana", 0.3);
        itemPrices.put("Orange", 0.7);
        itemPrices.put("Bread", 1.5);
        itemPrices.put("Milk", 2.0);

        itemStock.put("Apple", 10);
        itemStock.put("Banana", 15);
        itemStock.put("Orange", 8);
        itemStock.put("Bread", 6);
        itemStock.put("Milk", 12);
    }

    public void addCustomer(Customer customer) {
        checkoutQueue.add(customer);
    }

    public void removeCustomer() {
        if (!checkoutQueue.isEmpty()) {
            checkoutQueue.poll();
        } else {
            System.out.println("No customers in the queue.");
        }
    }

    public void printQueue() {
        System.out.println("Customers in the queue:");
        for (Customer customer : checkoutQueue) {
            System.out.println(customer.getItems());
        }
    }

    public double fetchItemPrice(String item) {
        return itemPrices.getOrDefault(item, 0.0);
    }

    public void updateStock(String item, int quantity) {
        if (itemStock.containsKey(item)) {
            itemStock.put(item, itemStock.get(item) - quantity);
        }
    }

    public void processCheckout() {
        if (!checkoutQueue.isEmpty()) {
            Customer customer = checkoutQueue.poll();
            double totalCost = 0.0;

            for (String item : customer.getItems()) {
                if (itemStock.containsKey(item) && itemStock.get(item) > 0) {
                    totalCost += fetchItemPrice(item);
                    updateStock(item, 1);
                    System.out.println("Item: " + item + ", Price: " + fetchItemPrice(item));
                } else {
                    System.out.println("Item: " + item + " is out of stock.");
                }
            }

            System.out.println("Total cost: " + totalCost);
        } else {
            System.out.println("No customers to process.");
        }
    }

    public void printStock() {
        System.out.println("Current stock:");
        for (Map.Entry<String, Integer> entry : itemStock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();

  
        Customer customer1 = new Customer();
        customer1.addItem("Apple");
        customer1.addItem("Banana");

        Customer customer2 = new Customer();
        customer2.addItem("Orange");
        customer2.addItem("Bread");

        Customer customer3 = new Customer();
        customer3.addItem("Milk");
        customer3.addItem("Apple");
        customer3.addItem("Apple");

        supermarket.addCustomer(customer1);
        supermarket.addCustomer(customer2);
        supermarket.addCustomer(customer3);

       
        supermarket.printQueue();

     
        supermarket.processCheckout();
        supermarket.processCheckout();
        supermarket.processCheckout();

        supermarket.printStock();
    }
}
