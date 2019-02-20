package lesson3.queue;

import lesson3.queue.PriorityQueue;

public class MainPriotityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
        pq.insert(1);
        pq.insert(5);
        pq.insert(4);
        pq.insert(3);
        pq.insert(2);

        System.out.println("size = " + pq.size);
        System.out.println("remove " + pq.remove());

        pq.insert(10);
        while (!pq.isEmpty()) {
            System.out.println("remove " + pq.remove());
        }
    }
}
