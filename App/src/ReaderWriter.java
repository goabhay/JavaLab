class SharedResource {
    private int data = 0;
    private int readerCount = 0;
    private boolean writerWriting = false;

    public synchronized int readData() throws InterruptedException {
        while (writerWriting) {
            wait();
        }
        readerCount++;
        int result = data;
        System.out.println("Reader reads: " + result);
        readerCount--; 
        if (readerCount == 0) notify();
        return result;
    }

    public synchronized void writeData(int newData) throws InterruptedException {
        while (readerCount > 0 || writerWriting) {
            wait();
        }
        writerWriting = true;
        data = newData;
        System.out.println("Writer writes: " + newData);
        writerWriting = false;
        notifyAll(); 
    }
}

class Reader implements Runnable {
    private SharedResource resource;

    Reader(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                int data = resource.readData();
                System.out.println("Reader " + Thread.currentThread().getId() + " reads: " + data);
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
               // e.printStackTrace();
                Thread.currentThread().interrupt(); 
            }
        }
    }
}

class Writer implements Runnable {
    private SharedResource resource;

    Writer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                resource.writeData(i);
                System.out.println("Writer " + Thread.currentThread().getId() + " writes: " + i);
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                //e.printStackTrace();
                Thread.currentThread().interrupt(); 
            }
        }
    }
}

public class ReaderWriter {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread readerThread1 = new Thread(new Reader(sharedResource));
        Thread readerThread2 = new Thread(new Reader(sharedResource));
        Thread writerThread1 = new Thread(new Writer(sharedResource));
        Thread writerThread2 = new Thread(new Writer(sharedResource));
        readerThread1.start();
        readerThread2.start();
        writerThread1.start();
        writerThread2.start();
    }
}
