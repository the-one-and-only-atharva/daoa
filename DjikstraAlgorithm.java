package Java;
import java.util.*;

public class DjikstraAlgorithm {
    static final int INF = 9999;

    // Function to find the vertex with the minimum distance value, from the set of vertices not yet included in the shortest path tree
    int minDist(int[] dist, boolean[] visited) {
        int min = INF, min_idx = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                min_idx = v;
            }
        }

        return min_idx;
    }

    void dijkstra(int graph[][], int src) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        // Initialize all distances as INFINITE and visited[] as false
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDist(dist, visited);

            // Mark the picked vertex as processed
            visited[u] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int v = 0; v < V; v++) {
                // Update dist[v] if is not in visited, there is an edge from u to v,
                // and total weight of path from src to v through u is smaller than current value of dist[v]
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
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

        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();

        scanner.close();

        DjikstraAlgorithm t = new DjikstraAlgorithm();
        t.dijkstra(graph, source);
    }
}

