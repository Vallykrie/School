package Praktikum;

import java.util.Arrays;

public class nathan_051_9_1 {
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        int n = than.nextInt();
        than.nextLine();
        WeightedUM graph1 = new WeightedUM(n);
        WeightedDM graph2 = new WeightedDM(n);

        String[] inputUM = than.nextLine().split(" ");
        String[] inputDM = than.nextLine().split(" ");
        for (String string : inputUM) {
            String[] temp = string.split(",");
            graph1.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        }
        for (String string : inputDM) {
            String[] temp = string.split(",");
            graph2.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        }

        System.out.println("Weighted Undigraph List");
        graph1.getNodes();
        graph1.printMatrix();
        graph1.BFS(1);
        graph1.DFS(1);

        System.out.println("Weighted Digraph Matrix");
        graph2.getNodes();
        graph2.printMatrix();
        graph2.BFS(1);
        graph2.DFS(1);

    }
}

class WeightedUM {
    int[][] data;
    int size;

    public WeightedUM(int size) {
        this.size = size;
        data = new int[size][size];
    }

    public void getNodes() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void addEdge(int node1, int node2, int weight) {
        data[node1 - 1][node2 - 1] = weight;
        data[node2 - 1][node1 - 1] = weight;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            // System.out.println(Arrays.toString(data[i]));
            System.out.print((i + 1));
            for (int j = 0; j < size; j++) {
                if (data[i][j] > 0) {
                    System.out.print("  -> " + (j + 1) + " : " + data[i][j]);
                }
            }
            System.out.println();
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue queue = new Queue();
        visited[start - 1] = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        while (queue.getSize() != 0) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 0; i < size; i++) {
                if (data[start - 1][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i + 1);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[size];
        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    public void DFS(int start, boolean[] visited) {
        visited[start - 1] = true;
        System.out.print(start + " ");
        for (int i = 0; i < size; i++) {
            if (data[start - 1][i] > 0 && !visited[i]) {
                DFS(i + 1, visited);
            }
        }
    }
}

class WeightedDM {
    int[][] data;
    int size;

    public WeightedDM(int size) {
        this.size = size;
        data = new int[size][size];
    }

    public void getNodes() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void addEdge(int node1, int node2, int weight) {
        data[node1 - 1][node2 - 1] = weight;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue queue = new Queue();
        visited[start - 1] = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        while (queue.getSize() != 0) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 0; i < size; i++) {
                if (data[start - 1][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i + 1);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[size];
        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    public void DFS(int start, boolean[] visited) {
        visited[start - 1] = true;
        System.out.print(start + " ");
        for (int i = 0; i < size; i++) {
            if (data[start - 1][i] > 0 && !visited[i]) {
                DFS(i + 1, visited);
            }
        }
    }
}

class NodeQueue {
    int data;
    NodeQueue next;

    public NodeQueue(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    NodeQueue head, tail;
    int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public int poll() {
        int temp = head.data;
        dequeue();
        return temp;
    }
}