package Playground;

import java.util.Arrays;

public class MaxProfitByCategory {
    public static void main(String[] args) {
        int[] category = {3, 1, 2, 3};
        int[] price = {2, 1, 4, 4};
        System.out.println(findMaximumProfit(category, price));
    }

    public static long findMaximumProfit(int[] category, int[] price) {
        int n = category.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[category[i]]++;
        }
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(price[b] * count[category[a]], price[a] * count[category[b]]));
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int j = indices[i];
            ans += sum * price[j];
            sum += count[category[j]];
        }
        return ans;
    }
}
