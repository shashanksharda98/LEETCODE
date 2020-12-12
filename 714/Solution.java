class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bought = -prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; i++){
            int tempsell = Math.max((prices[i] - fee + bought), sell);
            int tempbought = Math.max(sell - prices[i], bought);
            sell = tempsell;
            bought = tempbought;
            
        }
        return sell;
    }
}