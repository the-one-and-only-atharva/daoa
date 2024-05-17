package Java;
import java.util.*;

public class TSP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        
        int[][] dist = new int[n][n];
        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }
        
        boolean[] visited = new boolean[n];
        visited[0] = true; // Mark the starting node as visited
        int c = tsp(n, dist, visited, 1, 0);
        System.out.println("Cost: " + c);
        
        scanner.close();
    }

    public static int tsp(int n, int[][] dist, boolean[] visited, int visitedCount, int current) {
        if (visitedCount == n) {
            return dist[current][0]; // Return to the starting node
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true; // Mark the node as visited
                int newc = dist[current][i] + tsp(n, dist, visited, visitedCount + 1, i);
                min = Math.min(min, newc);
                visited[i] = false; // Backtrack: Mark the node as not visited
            }
        }
        return min;
    }
}
