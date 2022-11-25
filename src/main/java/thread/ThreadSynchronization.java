package thread;

public class ThreadSynchronization {

    static class Account {
        private int balance = 50;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            balance = balance - amount;
        }
    }

    static class AccountDanger implements Runnable {
        private Account acct = new Account();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                makeWithdrawal(10);
                if (acct.getBalance() < 0) {
                    System.out.println("account is overdrawn!");
                }
            }
        }

        //method level synchronization

//        private synchronized void makeWithdrawal(int amt){
//            if(acct.getBalance()>=amt){
//                System.out.println(Thread.currentThread().getName()
//                +" is going to withdraw");
//                try {
//                    Thread.sleep(5);
//                }catch (InterruptedException ex){}
//                acct.withdraw(amt);
//                System.out.println(Thread.currentThread().getName()
//                +" completes the withdrawal");
//            }else {
//                System.out.println("Not enough in account for "
//                + Thread.currentThread().getName()
//                + " to withdraw "+ acct.getBalance());
//            }
//        }


        // block level synchronization
        private void makeWithdrawal(int amt) {
            synchronized (this) {
                if (acct.getBalance() >= amt) {
                    System.out.println(Thread.currentThread().getName()
                            + " is going to withdraw");
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                    }
                    acct.withdraw(amt);
                    System.out.println(Thread.currentThread().getName()
                            + " completes the withdrawal");
                } else {
                    System.out.println("Not enough in account for "
                            + Thread.currentThread().getName()
                            + " to withdraw " + acct.getBalance());
                }
            }
        }
    }

    public static void main(String[] args) {
        AccountDanger accountDanger = new AccountDanger();
        Thread one = new Thread(accountDanger);
        Thread two = new Thread(accountDanger);
        Thread three = new Thread(accountDanger);
        Thread four = new Thread(accountDanger);

        one.setName("Rocky");
        two.setName("Lucy");
        three.setName("Tuli");
        four.setName("Jannat");

        one.start();
        two.start();
        three.start();
        four.start();
    }


}
