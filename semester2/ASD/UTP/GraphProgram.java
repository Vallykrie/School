
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class GraphProgram {

    public void dijkstra(WeightedGraph graph, int startVertex) {
        int numVertices = graph.numVertices;
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int vertex = node.vertex;

            if (!visited[vertex]) {
                visited[vertex] = true;

                for (int i = 0; i < numVertices; i++) {
                    int edgeDistance = graph.getEdge(vertex, i);
                    if (edgeDistance != Integer.MAX_VALUE && !visited[i]
                            && distances[vertex] + edgeDistance < distances[i]) {
                        distances[i] = distances[vertex] + edgeDistance;
                        pq.add(new Node(i, distances[i]));
                    }
                }
            }
        }

        printDistances(distances);
    }

    private void printDistances(int[] distances) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + (distances[i] == Integer.MAX_VALUE ? "∞" : distances[i]));
        }
    }

    public static void main(String[] args) {
        Graph simpleGraph = new Graph(5);
        simpleGraph.addEdge(0, 1);
        simpleGraph.addEdge(0, 4);
        simpleGraph.addEdge(1, 2);
        simpleGraph.addEdge(1, 3);
        simpleGraph.addEdge(1, 4);
        simpleGraph.addEdge(2, 3);
        simpleGraph.addEdge(3, 4);

        GraphTraversal traversal = new GraphTraversal();
        System.out.println("BFS:");
        traversal.BFS(simpleGraph, 0);

        System.out.println("DFS:");
        traversal.DFS(simpleGraph, 0);

        WeightedGraph weightedGraph = new WeightedGraph(5);
        weightedGraph.addEdge(0, 1, 10);
        weightedGraph.addEdge(0, 4, 3);
        weightedGraph.addEdge(1, 2, 2);
        weightedGraph.addEdge(1, 4, 4);
        weightedGraph.addEdge(2, 3, 9);
        weightedGraph.addEdge(3, 2, 7);
        weightedGraph.addEdge(4, 1, 1);
        weightedGraph.addEdge(4, 2, 8);
        weightedGraph.addEdge(4, 3, 2);

        GraphProgram sp = new GraphProgram();
        System.out.println("Dijkstra's Shortest Path:");
        sp.dijkstra(weightedGraph, 0);
    }
}

class Graph {
    int numVertices;
    int[][] adjacencyMatrix;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 1;
        adjacencyMatrix[dest][src] = 1;
    }

    public void removeEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = 0;
        adjacencyMatrix[dest][src] = 0;
    }

    public boolean hasEdge(int src, int dest) {
        return adjacencyMatrix[src][dest] != 0;
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class GraphTraversal {

    public void BFS(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < graph.numVertices; i++) {
                if (graph.hasEdge(vertex, i) && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public void DFS(Graph graph, int startVertex) {
        boolean[] visited = new boolean[graph.numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");
            }

            for (int i = graph.numVertices - 1; i >= 0; i--) {
                if (graph.hasEdge(vertex, i) && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }
}

class WeightedGraph {
    int numVertices;
    int[][] adjacencyMatrix;

    public WeightedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight; // Untuk graf tak berarah
    }

    public void removeEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = Integer.MAX_VALUE;
        adjacencyMatrix[dest][src] = Integer.MAX_VALUE; // Untuk graf tak berarah
    }

    public int getEdge(int src, int dest) {
        return adjacencyMatrix[src][dest];
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print((adjacencyMatrix[i][j] == Integer.MAX_VALUE ? "∞" : adjacencyMatrix[i][j]) + " ");
            }
            System.out.println();
        }
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}