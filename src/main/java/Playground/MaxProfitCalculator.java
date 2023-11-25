package Playground;

import java.util.HashMap;
import java.util.Map;

public class MaxProfitCalculator {

    public static int getTotalProfit(int[] categories, int[] prices) {
        if (categories == null || prices == null || categories.length != prices.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> lastSoldIndex = new HashMap<>();
        Map<Integer, Integer> categoryToProfit = new HashMap<>();
        int totalProfit = 0;

        for (int i = 0; i < categories.length; i++) {
            int category = categories[i];
            int price = prices[i];

            // If the category was sold before, update the total profit
            if (lastSoldIndex.containsKey(category)) {
                int lastSold = lastSoldIndex.get(category);
                int differentCategoriesSold = i - lastSold;
                totalProfit += categoryToProfit.get(category) * differentCategoriesSold;
            }

            // Update the last sold index and profit for the category
            lastSoldIndex.put(category, i);
            categoryToProfit.put(category, price);
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] categories = {3, 1, 2, 3};
        int[] prices = {2, 1, 4, 4};

        int totalProfit = getTotalProfit(categories, prices);

        System.out.println("Total Profit: " + totalProfit);
    }
}
