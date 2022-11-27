package core_java.thread;


public class WaitAndNotify {
    static Object lock = new Object();
    static int threadCount = 0;
    static int waitCount = 0;

    static class Calculator implements Runnable {
        int total;


        @Override
        public void run() {
            synchronized (lock) {
                //General computation
                for (int i = 0; i < 100; i++) {
                    total += i;
                }
                System.out.println("Calculation finished: " + Thread.currentThread().getName());
                lock.notifyAll();
            }

        }
    }


    static class Reader implements Runnable {
        Calculator calculator;

        public Reader(Calculator calculator) {
            this.calculator = calculator;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("Waiting for the calculation...");
                    waitCount++;
                    lock.wait();
                    System.out.println("I get notification" + Thread.currentThread().getName());
                } catch (InterruptedException ex) {
                    System.out.println("Total is: " + calculator.total);
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator();
        Thread readerOne = new Thread(new Reader(calculator));
        Thread readerTwo = new Thread(new Reader(calculator));
        Thread readerThree = new Thread(new Reader(calculator));


        readerOne.start();
        threadCount++;


        readerTwo.start();
        threadCount++;


        readerThree.start();
        threadCount++;

        while (true){
            if(waitCount==threadCount) {
                Thread cal = new Thread(new Calculator());
                cal.start();
                break;
            }
        }
    }


}

