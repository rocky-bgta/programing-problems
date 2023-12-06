package leetCode.map_count;

/*
    https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1?page=1&category=Arrays&sortBy=submissions


    GFG (Problem)

    Explanation:
    https://www.youtube.com/watch?v=5L9Jrehvoew


    Example 1:

    Input:
    N = 4, K = 6
    arr[] = {1, 5, 7, 1}
    Output: 2
    Explanation:
    arr[0] + arr[1] = 1 + 5 = 6
    and arr[1] + arr[3] = 5 + 1 = 6.

    Example 2:

    Input:
    N = 4, K = 2
    arr[] = {1, 1, 1, 1}
    Output: 6
    Explanation:
    Each 1 will produce sum 2 with any 1.


 */

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
       int N = 4, K = 2;
       int arr[] = {1, 1, 1, 1};
       getPairsCount(arr,N,K);
    }

    public static int getPairsCount(int[] arr, int n, int k) {
        // code here
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int val = k - arr[i];

            if (m.containsKey(val)) {
                ans += m.get(val);
            }

            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        return ans;
    }
}
