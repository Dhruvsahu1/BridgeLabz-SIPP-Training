
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BakeryOrderSystem {
    private Queue<Order> orderQueue;
    private List<Order> orderList;

    public BakeryOrderSystem() {
        this.orderQueue = new LinkedList<>();
        this.orderList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
        orderList.add(order);
    }

    public Order deliverNextOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to deliver.");
            return null;
        }
        Order nextOrder = orderQueue.poll();
        orderList.remove(nextOrder);
        return nextOrder;
    }

    public List<Order> filterOrdersByCategory(String category) {
        return orderList.stream()
                .filter(order -> order.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public void displayOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            orders.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        BakeryOrderSystem bakery = new BakeryOrderSystem();

        bakery.addOrder(new Order("Chocolate Cake", 1, "Cake"));
        bakery.addOrder(new Order("Vanilla Cupcake", 12, "Cookie"));
        bakery.addOrder(new Order("Blueberry Muffin", 6, "Pastry"));
        bakery.addOrder(new Order("Red Velvet Cake", 1, "Cake"));
        bakery.addOrder(new Order("Cherry Tart", 4, "Pastry"));

        System.out.println("All Orders:");
        bakery.displayOrders(bakery.orderList);

        System.out.println("\nCake Orders:");
        bakery.displayOrders(bakery.filterOrdersByCategory("Cake"));

        System.out.println("\nCookie Orders:");
        bakery.displayOrders(bakery.filterOrdersByCategory("Cookie"));

        System.out.println("\nPastry Orders:");
        bakery.displayOrders(bakery.filterOrdersByCategory("Pastry"));

        System.out.println("\nDelivering the next order:");
        System.out.println(bakery.deliverNextOrder());

        System.out.println("\nDelivering the next order:");
        System.out.println(bakery.deliverNextOrder());

      
        System.out.println("\nRemaining Orders:");
        bakery.displayOrders(bakery.orderList);
    }
}
