class Solution {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int left_difrnce = 0, right_difrnce = 0, min_so_far = 0, max_so_far = 0;
        int n = prices.length;
        int j = n - 1;
        for(int i = 0; i < prices.length; i++){
            if(i == 0){
                min_so_far = prices[i];
                max_so_far = prices[j];
                left[i] = left_difrnce;
                right[j] = right_difrnce;
            }else{
                if(prices[i] < min_so_far) min_so_far = prices[i];
                if(prices[j] > max_so_far) max_so_far = prices[j];
                
                if(prices[i] - min_so_far > left_difrnce) left_difrnce = prices[i] - min_so_far;
                if(max_so_far - prices[j] > right_difrnce) right_difrnce = max_so_far - prices[j];
                left[i] = left_difrnce;
                right[j] = right_difrnce;
            }
            j--;
        }
        int ans = 0;
        for(int i = 0; i < left.length; i++){
            if(left[i] + right[i] > ans) ans = left[i] + right[i];
        }
        return ans;
    }
}