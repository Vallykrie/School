import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * test
 */
public class test {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < 10; i++) {
            int num = Math.random()*10+1;
            minHeap.add(num);
            maxHeap.add(num);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(minHeap.peek());
            System.out.println(maxHeap.peek());
        }
//        minHeap.remove()
    }
}