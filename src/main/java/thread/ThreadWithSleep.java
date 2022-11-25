package thread;

public class ThreadWithSleep {

    static class NewRunnable implements Runnable{
        @Override
        public void run() {
            for(int x=1; x<4; x++){
                System.out.println("Run by " + Thread.currentThread()
                        .getName());
            }
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){}
        }
    }


    public static void main(String[] args) {
        NewRunnable newRunnable = new NewRunnable();

        Thread one = new Thread(newRunnable);
        one.setName("Rocky");

        Thread two = new Thread(newRunnable);
        two.setName("Tuli");

        Thread three = new Thread(newRunnable);
        three.setName("Tahim");

        one.start();
        two.start();
        three.start();

    }
}
