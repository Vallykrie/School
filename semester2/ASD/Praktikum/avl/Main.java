package Praktikum.avl;
import java.util.Scanner;
import java.util.StringJoiner;

class SocialMediaGraph {
    static final int MAX_USERS = 100;
    int[][] adjMatrix = new int[MAX_USERS][MAX_USERS];
    String[] users = new String[MAX_USERS];
    int userCount = 0;

    public void insertUser(String username) {
        if (userCount >= MAX_USERS) {
            //System.out.println("User limit reached");
            return;
        }
        for (int i = 0; i < userCount; i++) {
            if (users[i].equals(username)) {
                System.out.println(username + " already exists");
                return;
            }
        }
        users[userCount] = username;
        System.out.println(username + " inserted");
        userCount++;
    }

    public void connectUser(String username1, String username2) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < userCount; i++) {
            if (users[i].equals(username1)) index1 = i;
            if (users[i].equals(username2)) index2 = i;
        }
        if (index1 == -1 && index2 == -1) {
            System.out.println("username " + username1 + " and " + username2 + " not found");
        } else if (index1 == -1) {
            System.out.println("username " + username1 + " not found");
        } else if (index2 == -1) {
            System.out.println("username " + username2 + " not found");
        } else {
            adjMatrix[index1][index2] = 1;
            System.out.println("connect " + username1 + " with " + username2 + " success");
        }
    }

    public void mostFollowed() {
        if (userCount == 0) {
            System.out.println("");
            return;
        }
        int maxFollowers = 0;
        int[] followersCount = new int[userCount];
        for (int i = 0; i < userCount; i++) {
            for (int j = 0; j < userCount; j++) {
                if (adjMatrix[j][i] == 1) {
                    followersCount[i]++;
                }
            }
            if (followersCount[i] > maxFollowers) {
                maxFollowers = followersCount[i];
            }
        }
        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < userCount; i++) {
            if (followersCount[i] == maxFollowers) {
                sj.add(users[i]);
            }
        }
        System.out.println(sj.toString() + " with " + maxFollowers + " total followers");
    }

    public void numGroups() {
        boolean[] visited = new boolean[userCount];
        int groups = 0;
        for (int i = 0; i < userCount; i++) {
            if (!visited[i]) {
                bfs(i, visited);
                groups++;
            }
        }
        System.out.println("number of groups: " + groups);
    }

    private void bfs(int start, boolean[] visited) {
        Queue queue = new Queue();
        queue.enqueue(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < userCount; i++) {
                if (!visited[i] && (adjMatrix[node][i] == 1 || adjMatrix[i][node] == 1)) {
                    queue.enqueue(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void followers(String username) {
        int index = -1;
        for (int i = 0; i < userCount; i++) {
            if (users[i].equals(username)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("username " + username + " not found");
            return;
        }
        int count = 0;
        for (int i = 0; i < userCount; i++) {
            if (adjMatrix[i][index] == 1) {
                count++;
            }
        }
        System.out.println(count);
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
    NodeQueue front, rear;
    int size = 0;

    public Queue() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        NodeQueue newNode = new NodeQueue(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SocialMediaGraph graph = new SocialMediaGraph();
        int numberOfCommands = Integer.parseInt(in.nextLine().trim());

        for (int i = 0; i < numberOfCommands; i++) {
            String input = in.nextLine().trim();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "insert":
                    graph.insertUser(parts[1]);
                    break;
                case "connect":
                    graph.connectUser(parts[1], parts[2]);
                    break;
                case "mostfollowed":
                    graph.mostFollowed();
                    break;
                case "followers":
                    graph.followers(parts[1]);
                    break;
                case "numgroups":
                    graph.numGroups();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        in.close();
    }
}