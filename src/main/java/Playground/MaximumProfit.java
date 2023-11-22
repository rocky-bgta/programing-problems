package Playground;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumProfit {

    static long findMaximumProfit(List<Integer> category, List<Integer> price) {
        int n = category.size();

        // Create a map to store the last seen index of each category
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();

        long totalProfit = 0;  // To store the total profit
        int distinctCategories = 0;  // To store the count of different categories seen so far

        for (int i = 0; i < n; i++) {
            int currentCategory = category.get(i);
            int currentPrice = price.get(i);

            // If the current category has been seen before, update the count
            if (lastSeenIndex.containsKey(currentCategory)) {
                distinctCategories++;
            }

            // Calculate profit and update total profit
            long profit = (long) currentPrice * distinctCategories;
            totalProfit += profit;

            // Update the last seen index of the current category
            lastSeenIndex.put(currentCategory, i);
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        // Example with List<Integer>
        List<Integer> category = Arrays.asList(3,1,2,3);
        List<Integer> price = Arrays.asList(2,1,4,4);

        long result = findMaximumProfit(category, price);
        System.out.println("Maximum Profit: " + result);
    }
}
