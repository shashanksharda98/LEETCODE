class Solution {
    public int maxProfit(int[] prices) {
        int min_so_far = 0, max_difference = 0;
        for(int i = 0; i < prices.length; i++){
            if(i == 0) min_so_far = prices[i];
            else if(prices[i] < min_so_far) min_so_far = prices[i];
            else if(prices[i] - min_so_far > max_difference) max_difference = prices[i] - min_so_far;
        }
        return max_difference;
    }
}