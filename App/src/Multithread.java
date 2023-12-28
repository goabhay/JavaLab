
import java.util.LinkedList;

class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public int produce(int item) throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == capacity)  wait();
           buffer.add(item);
         notifyAll();

            return item;
        }
    }

    public int consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.isEmpty()) {
                wait();
            }

            int item = buffer.removeFirst();
           // System.out.println("Consumed: " + item);

          
            notifyAll();

            return item;
        }
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                int producedItem = buffer.produce(i);
                System.out.println("Producer produced: " + producedItem);
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
              
                Thread.currentThread().interrupt(); 
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                int consumedItem = buffer.consume();
                System.out.println("Consumer consumed: " + consumedItem);
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
               
                Thread.currentThread().interrupt(); 
            }
        }
    }
}


public class Multithread {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(2);
        
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

