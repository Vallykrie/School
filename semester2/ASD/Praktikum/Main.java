// package Praktikum;

class Node {
    String username;
    Node next;

    Node(String u) {
        username = u;
        next = null;
    }
}

class Graph {
    Node[] vertices;
    int size;

    Graph(int maxSize) {
        vertices = new Node[maxSize];
        size = 0;
    }

    void insert(String username) {
        if (find(username) == null) {
            vertices[size++] = new Node(username);
            System.out.println(username + " inserted");
        } else {
            System.out.println(username + " already exists");
        }
    }

    void add(String username) {
        if (find(username) == null) {
            vertices[size++] = new Node(username);
            // System.out.println(username + " inserted");
        } else {
            // System.out.println(username + " already exists");
        }
    }

    Node find(String username) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].username.equals(username)) {
                return vertices[i];
            }
        }
        return null;
    }

    void connect(String username1, String username2) {
        Node user1 = find(username1);
        Node user2 = find(username2);

        if (user1 == null && user2 == null) {
            System.out.println("username " + username1 + " and " + username2 + " not found");
        } else if (user1 == null) {
            System.out.println("username " + username1 + " not found");
        } else if (user2 == null) {
            System.out.println("username " + username2 + " not found");
        } else {
            Node temp = user2.next;
            while (temp != null) {
                if (temp.username.equals(username2)) {
                    System.out.println("connection already exists between " + username1 + " and " + username2);
                    return;
                }
                temp = temp.next;
            }
            Node newNode = new Node(username1);
            newNode.next = user2.next;
            user2.next = newNode;
            System.out.println("connect " + username1 + " with " + username2 + " success");
        }
    }

    void check(String username1, String username2) {
        Node user1 = find(username1);
        Node user2 = find(username2);

        if (user1 == null && user2 == null) {
            // System.out.println("username " + username1 + " and " + username2 + " not
            // found");
        } else if (user1 == null) {
            // System.out.println("username " + username1 + " not found");
        } else if (user2 == null) {
            // System.out.println("username " + username2 + " not found");
        } else {
            Node temp = user1.next;
            while (temp != null) {
                if (temp.username.equals(username2)) {
                    // System.out.println("Connection already exists between " + username1 + " and "
                    // + username2);
                    return;
                }
                temp = temp.next;
            }
            Node newNode = new Node(username2);
            newNode.next = user1.next;
            user1.next = newNode;
            // System.out.println("Connect " + username1 + " with " + username2 + "
            // success");
        }
    }

    void mostFollowed() {
        int maxFollowers = 0;
        StringBuilder mostFollowedUsers = new StringBuilder();

        for (int i = 0; i < size; i++) {
            Node current = vertices[i].next;
            int followers = 0;
            while (current != null) {
                followers++;
                current = current.next;
            }
            if (followers > maxFollowers) {
                maxFollowers = followers;
                mostFollowedUsers = new StringBuilder(vertices[i].username);
            } else if (followers == maxFollowers) {
                mostFollowedUsers.append(", ").append(vertices[i].username);
            }
        }

        if (maxFollowers == 0) {
            System.out.println();
        } else {
            System.out.println(mostFollowedUsers + " with " + maxFollowers + " total followers");
        }
    }

    void numGroups() {
        boolean[] visited = new boolean[size];
        int groups = 0;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                groups++;
            }
        }
        System.out.println("number of groups: " + groups);
    }

    void dfs(int index, boolean[] visited) {
        visited[index] = true;
        Node current = vertices[index].next;
        while (current != null) {
            int neighborIndex = findIndex(current.username);
            if (!visited[neighborIndex]) {
                dfs(neighborIndex, visited);
            }
            current = current.next;
        }
    }

    int findIndex(String username) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].username.equals(username)) {
                return i;
            }
        }
        return -1;
    }

    int followersCount(String username) {
        Node user = find(username);
        if (user == null) {
            return -1;
        }

        int followers = 0;
        for (int i = 0; i < size; i++) {
            Node current = vertices[i].next;
            while (current != null) {
                if (current.username.equals(username)) {
                    followers++;
                }
                current = current.next;
            }
        }
        return followers;
    }
}

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int commands = scanner.nextInt();
        scanner.nextLine();

        Graph graph = new Graph(20);
        Graph clone = new Graph(20);

        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "insert":
                    graph.insert(parts[1]);
                    clone.add(parts[1]);
                    break;
                case "connect":
                    graph.connect(parts[1], parts[2]);
                    clone.check(parts[1], parts[2]);
                    break;
                case "mostfollowed":
                    graph.mostFollowed();
                    break;
                case "numgroups":
                    clone.numGroups();
                    break;
                case "followers":
                    int followers = graph.followersCount(parts[1]);
                    if (followers == -1) {
                        System.out.println("username " + parts[1] + " not found");
                    } else {
                        System.out.println(followers);
                    }
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
