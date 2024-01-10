package leetCode;

/*
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */

/*
    Explanation:
    https://www.youtube.com/watch?v=M7QXuX5QMe8
 */
public class BestTimeToBuyAndSellStockII_122 {

    public static void main(String[] args) {
//        Input: prices = [7,1,5,3,6,4]
//        Output: 7
//        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//        Total profit is 4 + 3 = 7

        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int buyingPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            // if the current price is less update the buy_price
            // in real life we will buy stoke when it's prices is less
            if(prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            }else {
                profit += prices[i] - buyingPrice;
                buyingPrice = prices[i];
            }
        }
        return profit;
    }
}
