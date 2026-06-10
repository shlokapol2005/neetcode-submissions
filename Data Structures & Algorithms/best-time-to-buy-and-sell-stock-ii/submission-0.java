class Solution {
    public int maxProfit(int[] prices) {


     int profit = 0;
     for(int i = 1; i< prices.length ; i++){    // start from day 2(i.e index=1) so u can compare with day 1

        if(prices[i] > prices[i-1]){
            profit += prices[i]-prices[i-1];

        }
     }   
     return profit;
    }
}