package core_java.thread.producer_consumer;

import java.util.Queue;

public class Consumer extends Thread {
    private final Queue<Integer> queue;
    private final int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize, String name){
        super(name);
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run(){
        while (true){
            synchronized (queue){
                while (queue.isEmpty()){
                    System.out.println("Queue is empty,"
                            + "Consumer thread is waiting"
                            + " for producer thread to put something in queue");

                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
