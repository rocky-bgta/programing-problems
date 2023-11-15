package agoda.preparation;

public class BuyAndSell {

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
       // int[] prices={7,6,4,3,1};
        System.out.println(getMaxProfit(prices));
    }

    public static Integer getMaxProfit(int[] price){
        //int i=0,j=0;
        int maxProfit = 0;
        int temProfit = 0;
        // Input: prices = [7,1,5,3,6,4]

        for(int i=1; i<price.length; i++){
            temProfit = price[i] - price[i-1];
            System.out.println("temProfit: "+ temProfit);



            if(temProfit>0){
                maxProfit =Math.max(temProfit,maxProfit);
            }
            System.out.println("max: "+ maxProfit);
        }
        return maxProfit;
    }
}
