package japan;

import java.util.HashSet;
import java.util.Set;

public class FindTheMissingNumber {

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return 0;
    }
    public static void findMissing(int arr[], int N)
    {
        int i;
        int temp[] = new int[N + 1];
        for (i = 0; i <= N; i++) {
            temp[i] = 0;
        }

        for (i = 0; i < N; i++) {
            System.out.println("arry value "+ arr[i]);
            int index = arr[i]-1;
            System.out.println("Index "+index);
            temp[arr[i] - 1] = 1;
        }

        int ans = 0;
        for (i = 0; i <= N; i++) {
            if (temp[i] == 0)
                ans = i + 1;
        }
        System.out.println(ans);
    }
    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 5 };
        int n = arr.length;

        int cen = (int) Math.ceil((float)1905/100);
        // Function call
        findMissing(arr, n);
    }

}
