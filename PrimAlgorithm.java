package Java;
import java.util.*;

public class PrimAlgorithm {
    public static final int INF = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the no. of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix, use INF for no direct edge");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source vexter: ");
        int src = sc.nextInt();

        boolean[] visited = new boolean[V];
        visited[src] = true;

        for(int edges = 0; edges < V - 1; edges++) {
            int min = INF, x = - 1, y = -1;
            for (int i = 0; i < V; i++) {
                if (visited[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!visited[j] && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            if (x != -1 && y != -1) {
                System.out.println(x + "->" + y + ": " + graph[x][y]);
                visited[y] = true;
            }
        }

        sc.close();
    }
}
