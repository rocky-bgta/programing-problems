package hackerRank;

public class Test {

    public static void main(String[] args) {

        int ar[] = {1,0,8,9,0,7,2,0};

        for(int i=0; i<ar.length; i++){

            if(ar[i]==0) {
                ar[i] = ar[i + 1];
                ar[ar.length - 1] = 0;
            }

        }

        for (int item: ar) {
            System.out.println(item);
        }

    }
}
