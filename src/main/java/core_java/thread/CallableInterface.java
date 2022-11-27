package core_java.thread;

import java.util.concurrent.*;

public class CallableInterface  {


    static class CallableImpl implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int count = ThreadLocalRandom.current().nextInt(1,11);
            for(int i=0; i<=count; i++){
                System.out.println("Running... "+ i);
            }

            Object test = new Object();
            return count;
        }
    }


    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int numberOfCpus = runtime.availableProcessors();

        Callable<Integer> callable = new CallableImpl();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfCpus);
        Future<Integer> integerFuture = executorService.submit(callable);

        try {
            Integer result = integerFuture.get();
            System.out.println("Result: "+ result);

        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Failed");
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }

    }

}
