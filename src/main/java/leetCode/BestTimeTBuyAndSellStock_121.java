package leetCode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// https://www.youtube.com/watch?v=34WE6kwq49U
public class BestTimeTBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFer = prices[0];

        for(int i =0; i<prices.length; i++){
            minSoFer = Math.min(minSoFer,prices[i]);
            int profit = prices[i] - minSoFer;
            maxProfit = Math.max(maxProfit,profit);
        }

        return maxProfit;
    }
}
