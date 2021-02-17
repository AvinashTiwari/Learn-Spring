package weavequeue;

import java.util.Queue;
import java.util.PriorityQueue;

class MergingTwoSortedQueues {
    public static void main(String[] args) {
        Queue first = new PriorityQueue<String>();
        Queue second = new PriorityQueue<String>();

        first.add("a");
        first.add("b");
        first.add("g");
        first.add("h");

        second.add("A");
        second.add("c");
        second.add("d");
        second.add("e");
        second.add("f");

        System.out.println("First queue: ");
        System.out.println(first.toString());
        System.out.println("\nSecond queue: ");
        System.out.println(second.toString());

        Queue result = MergingTwoSortedQueues.merge(first, second);

        System.out.println("\nMerged queue: ");
        System.out.println(result.toString());
    }

    public static Queue<String> merge(Queue<String> first, Queue<String> second) {
        Queue<String> mergedQueue = new PriorityQueue<String>();

        // If both queues are not empty.
        while (!first.isEmpty() && !second.isEmpty()) {
            String left = first.peek();
            String right = second.peek();

            if (left.compareTo(right) < 0) {
                mergedQueue.add(first.poll());
            } else {
                mergedQueue.add(second.poll());
            }
        }

        // If there are remaining items in one of the queue.
        while (!first.isEmpty()) {
            mergedQueue.add(first.poll());
        }

        while (!second.isEmpty()) {
            mergedQueue.add(second.poll());
        }

        return mergedQueue;
    }
}