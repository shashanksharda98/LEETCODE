class Solution {
    public int maxProfit(int[] prices) {
      
        int profit = 0;
        int buy = 0;
        int sell = 0;
        for(int i = 0; i < prices.length; i++){
            if(i == 0){
                buy = prices[i];
                sell = prices[i];
            }
            else if(prices[i] > sell) sell = prices[i];
            else if(prices[i] < sell){
                profit += (sell - buy);
                buy = prices[i];
                sell = prices[i];
            }
            
            if(i == prices.length - 1) profit += (sell - buy);
        }
        return profit;
    }
}