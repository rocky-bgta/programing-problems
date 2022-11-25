package thread;

public class DeadLockTest {

    //Book reference OCA/OCP  page:754(802/994)

    private static class Resource{
        public int value;
    }

    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    public int read(){
        synchronized (resourceA){
            synchronized (resourceB){
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a, int b){
        synchronized (resourceB){
            synchronized (resourceA){
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }


    public static void main(String[] args) {

        final String resource1 = "rocky";
        final String resource2 = "Tuli";

        Thread.currentThread().getName();

        ReaderWorker readerWorker = new ReaderWorker();
        WriteWorker writeWorker = new WriteWorker();

        Thread threadRead = new Thread(readerWorker);
        Thread threadWrite = new Thread(writeWorker);
        threadRead.start();
        threadWrite.start();

        System.out.println("======== End Execution =======");

    }

   static class ReaderWorker implements Runnable{
        DeadLockTest deadLockTest = new DeadLockTest();
        @Override
        public void run() {
            deadLockTest.read();
        }
    }

   static class WriteWorker implements Runnable{
        DeadLockTest deadLockTest = new DeadLockTest();
        @Override
        public void run(){
            deadLockTest.write(10,20);
        }
    }


}
