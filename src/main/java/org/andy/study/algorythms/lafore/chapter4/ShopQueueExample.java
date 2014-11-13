package org.andy.study.algorythms.lafore.chapter4;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author andy
 */
public class ShopQueueExample {
    public static void main(String[] args) {
        final ShopQueueExample queues = new ShopQueueExample();
        queues.start();
    }
    
    private static final int THREAD_COUNT = 5;
    private static final int SLEEP_TIME = 100;
    
    List<QueueThread> threads = new LinkedList<>();
    private ShopQueueExample() {
        for(int i = 0; i < THREAD_COUNT; i++) {
            threads.add(new QueueThread(i + 1));
        }
    }

    private void start() {
        final ExecutorService pool = Executors.newFixedThreadPool(threads.size());
        threads.forEach(th -> {pool.submit(th);});
        int j = 0;
        while(true) {
            try {
                Thread.sleep(SLEEP_TIME);
                final Optional<QueueThread> minQueue = threads.stream().min((a, b) -> {return Integer.compare(a.size(), b.size());});
                minQueue.get().insertItem("Consumer " + ++j);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShopQueueExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    static class QueueThread implements Runnable {
        private final BlockingQueue<String> queue;
        private final int number;
        private final Random rand = new Random(hashCode());
        
        public QueueThread(int number) {
            queue = new LinkedBlockingQueue<>();
            this.number = number;
        }
        
        public void insertItem(String item) {
            System.out.println("Queue " + number + "Adding " + item + ". Size: " + size());
            queue.add(item);
        }
        
        @Override
        public void run() {
            Thread.currentThread().setName("Queue " + number);
            while(true) {
                try {
                    final String item = queue.take();
                    print("Started working on " + item);
                    Thread.sleep(rand.nextInt(1000) + 100);
                    print("Stopped working on " + item);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ShopQueueExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void print(String message) {
            System.out.println(Thread.currentThread().getName() + ": " + message);
        }

        private int size() {
            return queue.size();
        }
    }
}
