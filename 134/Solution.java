class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int prefix = 0, ans = -1, gas_sum = 0, cost_sum = 0, cr_neg = 0;
        for(int i = 0; i < gas.length; i++){
            int delta = gas[i] - cost[i];
            int new_prefix = prefix + delta;
            gas_sum += gas[i];
            cost_sum += cost[i];
            if(new_prefix < 0 && new_prefix < cr_neg){
                ans = i;
                cr_neg = new_prefix;
            }
            prefix = new_prefix;
        }
        if(cost_sum > gas_sum) return -1;
        return ans+1;
    }
}