package leetCode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// https://www.youtube.com/watch?v=E2-heUEnZKU
public class BestTimeTBuyAndSellStock_121 {

    public static void main(String[] args) {
        int [] prices = {7,6,4,3,1}; //output = 0
        //int [] prices = {7,1,5,3,6,4}; //output = 5
         //int[] prices={7,1,5,3,6,4};
        int result;
        result = maxProfit(prices);
        //result = getMaxProfit(prices);
        System.out.println(result);
    }
    public static int maxProfit(int[] prices) {
        // at the beginning the minimum price is the first price
        int buyPrice = prices[0];

        // at the beginning the minimum  profit is zero
        int profit = 0;

        for(int i=0; i<prices.length; i++){
            // if the current price is less update the buy_price
            if(prices[i]<buyPrice){
                buyPrice = prices[i];
            }else {
                // else check if we can get a better profit
                int currentProfit = prices[i]-buyPrice;
                profit = Math.max(currentProfit,profit);
            }
        }

        return profit;
    }

    //Brut force approach
    public static int getMaxProfit(int[] prices){
        int maxProfit=0,temMax;
        //  int[] prices={7,6,4,3,1};
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                temMax = prices[j]-prices[i];
                maxProfit = Math.max(temMax,maxProfit);
            }
        }
        return maxProfit;
    }
}
