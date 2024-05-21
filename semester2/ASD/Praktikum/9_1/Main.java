import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addAdj(0, 3, 2);
        g.addAdj(0, 1, 1);
        g.addAdj(1, 4, 3);
        g.addAdj(1, 2, 1);
        g.addAdj(2, 4, 4);
        g.addAdj(2, 1, 1);
        g.addAdj(4, 3, 1);
        g.print("Initial Graph:");

        System.out.println("BFS from node 0:");
        g.bfs(0);

        System.out.println("DFS from node 0:");
        g.dfs(0);

        System.out.println("Shortest path from node 0 to node 4:");
        g.dijkstra(0, 4);
    }
}

class Graph {
    private int[][] adjMatrix;
    private int jNode;

    public Graph(int n) {
        jNode = n;
        adjMatrix = new int[jNode][jNode];
        for (int i = 0; i < jNode; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }
    }

    public void addAdj(int head, int adj, int weight) {
        adjMatrix[head][adj] = weight;
    }

    public void print(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < jNode; i++) {
            System.out.print("[" + i + "]");
            for (int j = 0; j < jNode; j++) {
                if (adjMatrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print(" -> x");
                } else {
                    System.out.print(" -> " + adjMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[jNode];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < jNode; i++) {
                if (adjMatrix[node][i] != Integer.MAX_VALUE && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[jNode];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                System.out.print(node + " ");
                visited[node] = true;
            }

            for (int i = 0; i < jNode; i++) {
                if (adjMatrix[node][i] != Integer.MAX_VALUE && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public void dijkstra(int start, int end) {
        int[] dist = new int[jNode];
        boolean[] visited = new boolean[jNode];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if (visited[node])
                continue;
            visited[node] = true;

            for (int i = 0; i < jNode; i++) {
                if (adjMatrix[node][i] != Integer.MAX_VALUE && !visited[i]) {
                    int newDist = distance + adjMatrix[node][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.add(new int[] { i, newDist });
                    }
                }
            }
        }

        System.out.println("Shortest path from " + start + " to " + end + " is " + dist[end]);
    }

}
