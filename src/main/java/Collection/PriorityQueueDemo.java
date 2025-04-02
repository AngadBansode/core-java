package Collection;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    // minHeap vs maxHeap

    public static void main(String[] args) {
        // Create a PriorityQueue (default: Min-Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(15);

        // Poll elements (in ascending order)
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Output: 5, 10, 15, 20
        }

        // 2. maxHeap
//        A max-heap is a binary tree where the parent node is always greater than its child nodes.
//     In Java, you can create a max-heap by using a custom comparator.

        // Create a PriorityQueue with custom comparator (Max-Heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);
        maxHeap.add(15);

        // Poll elements (in descending order)
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // Output: 20, 15, 10, 5
        }

    }
}
