package Java;
import java.util.*;

public class Kruskals {
    static final int INF = 9999;

    static int find(int i, int[] parent) {
        return parent[i] == i ? i : (parent[i] = find(parent[i], parent));
    }

    static void unionSet(int i, int j, int[] parent) {
        parent[find(i, parent)] = find(j, parent);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        int[][] graph = new int[V][V];

        System.out.println("Enter the adjacency matrix (use " + INF + " for infinity):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int minCost = 0;
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int n = 0; n < V - 1; n++) {
            int min = INF, x = -1, y = -1;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (find(i, parent) != find(j, parent) && graph[i][j] < min) {
                        min = graph[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            unionSet(x, y, parent);
            minCost += min;
            System.out.println(x + " -> " + y + ": " + min);
        }
        System.out.println("Cost: " + minCost);

        scanner.close();
    }
}
