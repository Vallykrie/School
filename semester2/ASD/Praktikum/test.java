import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int commandsCount = than.nextInt();
        than.nextLine(); // Consume newline

        BT binaryTree = new BT();

        for (int i = 0; i < commandsCount; i++) {
            String command = than.nextLine();
            switch (command) {
                case "TAMBAH":
                    String directoryName = than.next();
                    int memorySize = than.nextInt();
                    if (than.hasNextLine()) {
                        than.nextLine();
                    }
                    binaryTree.addDirectory(directoryName, memorySize);
                    System.out.println(
                            "Direktori " + directoryName + " berhasil ditambah dengan memori sebesar " + memorySize);
                    break;
                case "CARI":
                    String directoryToFind = than.nextLine();
                    String path = binaryTree.findDirectory(directoryToFind);
                    System.out.println(path);
                    break;
                case "HITUNG":
                    String directoryToCalculate = than.nextLine();
                    int totalMemory = binaryTree.calculateMemorySize(directoryToCalculate);
                    if (totalMemory == -1) {
                        System.out.println("Direktori tidak ditemukan");
                    } else {
                        System.out.println("Besar memori " + directoryToCalculate + " = " + totalMemory);
                    }
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        than.close();
    }
}

class NodeBT {
    String directoryName;
    int memorySize;
    NodeBT left, right;

    public NodeBT(String directoryName, int memorySize) {
        this.directoryName = directoryName;
        this.memorySize = memorySize;
        left = right = null;
    }
}

class BT {
    NodeBT root;

    public BT() {
        root = null;
    }

    // Method to add a directory to the binary tree
    public void addDirectory(String directoryName, int memorySize) {
        root = addDirectoryRecursive(root, directoryName, memorySize);
    }

    private NodeBT addDirectoryRecursive(NodeBT root, String directoryName, int memorySize) {
        if (root == null) {
            return new NodeBT(directoryName, memorySize);
        }

        // Recursively add the directory to the left or right subtree
        if (directoryName.compareTo(root.directoryName) < 0) {
            root.left = addDirectoryRecursive(root.left, directoryName, memorySize);
        } else if (directoryName.compareTo(root.directoryName) > 0) {
            root.right = addDirectoryRecursive(root.right, directoryName, memorySize);
        }
        return root;
    }

    // Method to search for a directory and return its path
    public String findDirectory(String directoryName) {
        return findDirectoryRecursive(root, directoryName);
    }

    private String findDirectoryRecursive(NodeBT root, String directoryName) {
        if (root == null) {
            return "Direktori tidak ditemukan";
        }

        if (directoryName.equals(root.directoryName)) {
            return root.directoryName;
        }

        // Search in the left subtree if the directory comes before the root directory
        if (directoryName.compareTo(root.directoryName) < 0) {
            return findDirectoryRecursive(root.left, directoryName);
        }
        // Search in the right subtree if the directory comes after the root directory
        return findDirectoryRecursive(root.right, directoryName);
    }

    // Method to calculate the memory size of a directory and its sub-directories
    public int calculateMemorySize(String directoryName) {
        return calculateMemorySizeRecursive(root, directoryName);
    }

    private int calculateMemorySizeRecursive(NodeBT root, String directoryName) {
        if (root == null) {
            return -1; // Directory not found
        }

        if (directoryName.equals(root.directoryName)) {
            return calculateSubtreeMemorySize(root);
        }

        // Search in the left subtree if the directory comes before the root directory
        if (directoryName.compareTo(root.directoryName) < 0) {
            return calculateMemorySizeRecursive(root.left, directoryName);
        }
        // Search in the right subtree if the directory comes after the root directory
        return calculateMemorySizeRecursive(root.right, directoryName);
    }

    // Helper method to calculate memory size of a directory and its sub-directories
    private int calculateSubtreeMemorySize(NodeBT root) {
        if (root == null) {
            return 0;
        }
        // Recursively calculate memory size of left and right subtrees
        int leftSize = calculateSubtreeMemorySize(root.left);
        int rightSize = calculateSubtreeMemorySize(root.right);
        // Add memory size of the current node and return
        return root.memorySize + leftSize + rightSize;
    }
}
