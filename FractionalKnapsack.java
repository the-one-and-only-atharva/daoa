package Java;
import java.util.*;

public class FractionalKnapsack {
    static class Item {
        double value, weight, ratio;
        char id;

        public Item(char id, double value, double weight) {
            this.id = id;
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];

        // Read item details
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter details for item %d:\n", i + 1);
            System.out.print("ID (single character): ");
            char id = scanner.next().charAt(0);
            System.out.print("Value: ");
            double value = scanner.nextDouble();
            System.out.print("Weight: ");
            double weight = scanner.nextDouble();
            items[i] = new Item(id, value, weight);
        }

        // Knapsack capacity
        System.out.print("Enter the knapsack capacity: ");
        double capacity = scanner.nextDouble();
        scanner.close();

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.ratio).reversed());

        double totalValue = 0;

        System.out.println("Items taken: ");
        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
                System.out.printf("[%c 1.0] ", item.id);
            } else {
                double fraction = capacity / item.weight;
                totalValue += item.value * fraction;
                System.out.printf("[%c %.2f] ", item.id, fraction);
                break;
            }
        }

        System.out.printf("\nTotal value in knapsack is: %.2f\n", totalValue);
    }
}
