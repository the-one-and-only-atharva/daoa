package Java;
import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the size of the set
        System.out.print("Enter the size of the set: ");
        int n = scanner.nextInt();
        int[] set = new int[n];

        // Taking input for the set elements
        System.out.println("Enter the elements of the set:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            set[i] = scanner.nextInt();
        }

        // Taking input for the target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        findSubsetSum(set, target);

        scanner.close();
    }

    public static void findSubsetSum(int[] set, int target) {
        List<Integer> subset = new ArrayList<>();
        backtrack(set, target, 0, 0, subset);
    }

    public static void backtrack(int[] set, int target, int index, int sum, List<Integer> subset) {
        if (index == set.length) {
            if (sum == target) {
                System.out.println(subset);
            }
            return;
        }
        // Exclude current element
        backtrack(set, target, index + 1, sum, new ArrayList<>(subset));

        // Include current element
        subset.add(set[index]);
        backtrack(set, target, index + 1, sum + set[index], subset);
    }
}


