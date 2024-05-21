/**
 * This class represents a program that performs operations on groups of data.
 * It includes methods for inserting data into different groups, finding top groups based on certain criteria,
 * and sorting groups using the quicksort algorithm.
 */
public class nathan_051_10_2 {
    /**
     * The main method of the program.
     * It reads input from the user, performs operations on groups of data, and prints the results.
     *
     * @param args The command-line arguments passed to the program (not used in this program).
     */
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        Group[] nodedata = new Group[150];
        Group[] lingkungan = new Group[150];
        Group[] kesehatan = new Group[150];
        Group[] teknologi = new Group[150];
        int index = 0;
        int indexl = 0;
        int indexk = 0;
        int indext = 0;

        int n = than.nextInt();
        if (than.hasNextLine()) {
            than.nextLine();
        }
        for (int i = 0; i < n; i++) {
            String input = than.nextLine();
            String[] inpuptBagi = input.split(" ");
            if (inpuptBagi[0].equals("insert")) {
                String[] dataEntries = than.nextLine().split(";");
                for (String string : dataEntries) {
                    String[] data = string.split(" ");
                    String name = data[0];
                    int presentation = Integer.parseInt(data[1]);
                    int creativity = Integer.parseInt(data[2]);
                    int discussion = Integer.parseInt(data[3]);
                    int vote = Integer.parseInt(data[4]);
                    String field = data[5];
                    Group tmp = new Group(name, presentation, creativity, discussion, vote, field);

                    nodedata[index++] = tmp;
                    switch (field) {
                        case "Lingkungan": lingkungan[indexl++] = tmp; break;
                        case "Kesehatan": kesehatan[indexk++] = tmp; break;
                        case "Teknologi": teknologi[indext++] = tmp; break;
                    }
                }
                System.out.println("Berhasil memasukkan " + dataEntries.length + " data kelompok");

            } else if (inpuptBagi[0].equals("find")) {
                switch (inpuptBagi[1]) {
                    case "umum": System.out.println("Juara umum:"); printTopGroups(nodedata, index, 5, "score"); break;
                    case "favorit": System.out.println("Juara favorit:"); printTopGroups(nodedata, index, 2, "vote"); break;
                    case "lingkungan": System.out.println("Juara lingkungan:"); printTopGroups(lingkungan, indexl, 3, "score"); break;
                    case "kesehatan": System.out.println("Juara kesehatan:"); printTopGroups(kesehatan, indexk, 3, "score"); break;
                    case "teknologi": System.out.println("Juara teknologi:"); printTopGroups(teknologi, indext, 3, "score"); break;
                }
            }
        }
    }

    /**
     * Prints the top groups based on a given criterion.
     *
     * @param arr       The array of groups to be sorted and printed.
     * @param length    The length of the array.
     * @param topN      The number of top groups to be printed.
     * @param criterion The criterion used to determine the top groups (either "score" or "vote").
     */
    public static void printTopGroups(Group[] arr, int length, int topN, String criterion) {
        if (length == 0) {
            System.out.println();
            return;
        }

        Group[] sortedArray = new Group[length];
        System.arraycopy(arr, 0, sortedArray, 0, length);

        switch (criterion) {
            case "score": quickSort(sortedArray, 0, length - 1, "score"); break;
            case "vote": quickSort(sortedArray, 0, length - 1, "vote"); break;
        }

        int n = Math.min(topN, length);
        for (int i = 0; i < n; i++) {
            Group node = sortedArray[i];
            System.out.println((i + 1) + ". " + node.name + ": " + node.totalScore + ", " + node.vote);
        }
        System.out.println();
    }

    /**
     * Partitions the array of groups based on a given criterion.
     *
     * @param arr       The array of groups to be partitioned.
     * @param left      The left index of the partition.
     * @param right     The right index of the partition.
     * @param criterion The criterion used to determine the partition (either "score" or "vote").
     * @return The index of the pivot element after partitioning.
     */
    public static int partition(Group[] arr, int left, int right, String criterion) {
        Group pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            boolean condition = false;
            switch (criterion) {
                case "score": condition = arr[j].totalScore > pivot.totalScore; break;
                case "vote": condition = arr[j].vote > pivot.vote; break;
            }

            if (condition) {
                i++;
                Group tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        Group tmp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = tmp;

        return i + 1;
    }

    /**
     * Sorts the array of groups using the quicksort algorithm based on a given criterion.
     *
     * @param arr       The array of groups to be sorted.
     * @param left      The left index of the array.
     * @param right     The right index of the array.
     * @param criterion The criterion used to determine the sorting order (either "score" or "vote").
     */
    public static void quickSort(Group[] arr, int left, int right, String criterion) {
        if (left < right) {
            int mid = partition(arr, left, right, criterion);
            quickSort(arr, left, mid - 1, criterion);
            quickSort(arr, mid + 1, right, criterion);
        }
    }
}

/**
 * Represents a group with its name, field, presentation score, creativity score, discussion score, vote score, and total score.
 */
class Group {
    String name;
    String field;
    int presentation;
    int creativity;
    int discussion;
    int vote;
    int totalScore;

    /**
     * Constructs a new Group object with the specified name, presentation score, creativity score, discussion score, vote score, and field.
     * The total score is calculated based on the presentation, creativity, and discussion scores.
     *
     * @param name         the name of the group
     * @param presentation the presentation score of the group
     * @param creativity   the creativity score of the group
     * @param discussion   the discussion score of the group
     * @param vote         the vote score of the group
     * @param field        the field of the group
     */
    public Group(String name, int presentation, int creativity, int discussion, int vote, String field) {
        setName(name);
        setPresentation(presentation);
        setCreativity(creativity);
        setDiscussion(discussion);
        setVote(vote);
        setField(field);
        this.totalScore = (int) Math
                .round((presentation * 20 / 100) + (creativity * 50 / 100) + (discussion * 30 / 100));
    }

    /**
     * Sets the name of the group.
     *
     * @param name the name of the group
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the field of the group.
     *
     * @param field the field of the group
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * Sets the presentation score of the group.
     *
     * @param presentation the presentation score of the group
     */
    public void setPresentation(int presentation) {
        this.presentation = presentation;
    }

    /**
     * Sets the creativity score of the group.
     *
     * @param creativity the creativity score of the group
     */
    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    /**
     * Sets the discussion score of the group.
     *
     * @param discussion the discussion score of the group
     */
    public void setDiscussion(int discussion) {
        this.discussion = discussion;
    }

    /**
     * Sets the vote score of the group.
     *
     * @param vote the vote score of the group
     */
    public void setVote(int vote) {
        this.vote = vote;
    }

    /**
     * Returns a string representation of the group, including the name, total score, and vote score.
     *
     * @return a string representation of the group
     */
    @Override
    public String toString() {
        return name + ": " + totalScore + ", " + vote;
    }
}
