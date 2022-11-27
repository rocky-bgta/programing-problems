package core_java.thread.producer_consumer;

import java.util.Queue;
import java.util.Random;


public class Producer extends Thread {
    private final Queue<Integer> queue;
    private final int maxSize;


    public Producer(Queue<Integer> queue, int maxSize, String name) {
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, "
                                + "Producer thread waiting for "
                                + "consumer to take something from queue");

                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Random random = new Random();
                int i = random.nextInt();
                System.out.println("Producing value : " + i);
                queue.add(i);
                queue.notifyAll();
            }
        }

    }

}
