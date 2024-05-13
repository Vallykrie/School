import java.util.*;

class NodeGL {
    int node;
    int weight;
    NodeGL next;

    NodeGL(int node, int weight) {
        this.node = node;
        this.weight = weight;
        next = null;
    }
}

class WeightedUL {
    NodeGL[] vertices;
    int size;

    WeightedUL(int maxSize) {
        vertices = new NodeGL[maxSize];
        size = 0;
    }

    void insert(int node1, int node2, int weight) {
        NodeGL newNode1 = new NodeGL(node2, weight);
        newNode1.next = vertices[node1];
        vertices[node1] = newNode1;

        NodeGL newNode2 = new NodeGL(node1, weight);
        newNode2.next = vertices[node2];
        vertices[node2] = newNode2;
    }

    void printGraph() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " -> ");
            NodeGL current = vertices[i];
            while (current != null) {
                System.out.print((current.node + 1) + " (" + current.weight + ")");
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((node + 1) + " ");

            NodeGL current = vertices[node];
            while (current != null) {
                int neighbor = current.node;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
                current = current.next;
            }
        }
        System.out.println();
    }

    void dfs(int start) {
        boolean[] visited = new boolean[size];
        dfsUtil(start, visited);
        System.out.println();
    }

    void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print((node + 1) + " ");

        NodeGL current = vertices[node];
        while (current != null) {
            int neighbor = current.node;
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
            current = current.next;
        }
    }
}

class WeightedDL {
    NodeGL[] vertices;
    int size;

    WeightedDL(int maxSize) {
        vertices = new NodeGL[maxSize];
        size = 0;
    }

    void insert(int node1, int node2, int weight) {
        NodeGL newNode = new NodeGL(node2, weight);
        newNode.next = vertices[node1];
        vertices[node1] = newNode;
    }

    void printGraph() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " -> ");
            NodeGL current = vertices[i];
            while (current != null) {
                System.out.print((current.node + 1) + " (" + current.weight + ")");
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((node + 1) + " ");

            NodeGL current = vertices[node];
            while (current != null) {
                int neighbor = current.node;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
                current = current.next;
            }
        }
        System.out.println();
    }

    void dfs(int start) {
        boolean[] visited = new boolean[size];
        dfsUtil(start, visited);
        System.out.println();
    }

    void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print((node + 1) + " ");

        NodeGL current = vertices[node];
        while (current != null) {
            int neighbor = current.node;
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        scanner.nextLine();

        WeightedUL weightedUndigraphList = new WeightedUL(S);
        WeightedDL weightedDigraphList = new WeightedDL(S);

        String[] undigraphInput = scanner.nextLine().split(" ");
        for (String input : undigraphInput) {
            String[] parts = input.split(",");
            int node1 = Integer.parseInt(parts[0]) - 1;
            int node2 = Integer.parseInt(parts[1]) - 1;
            int weight = Integer.parseInt(parts[2]);
            weightedUndigraphList.insert(node1, node2, weight);
            weightedUndigraphList.size = Math.max(weightedUndigraphList.size, Math.max(node1, node2) + 1);
        }

        String[] digraphInput = scanner.nextLine().split(" ");
        for (String input : digraphInput) {
            String[] parts = input.split(",");
            int node1 = Integer.parseInt(parts[0]) - 1;
            int node2 = Integer.parseInt(parts[1]) - 1;
            int weight = Integer.parseInt(parts[2]);
            weightedDigraphList.insert(node1, node2, weight);
            weightedDigraphList.size = Math.max(weightedDigraphList.size, Math.max(node1, node2) + 1);
        }

        System.out.println("Weighted Undigraph List");
        weightedUndigraphList.printGraph();
        weightedUndigraphList.bfs(0);
        weightedUndigraphList.dfs(0);

        System.out.println("\nWeighted Digraph List");
        weightedDigraphList.printGraph();
        weightedDigraphList.bfs(0);
        weightedDigraphList.dfs(0);
    }
}
