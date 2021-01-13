class Solution {
    public int minOperations(int[] nums, int x) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int operations = Integer.MAX_VALUE, n = prefixSum.length;
        for(int j = n; j >= 1; j--){
            int rightHalf = j == n ? 0 : prefixSum[n-1] - prefixSum[j-1];
            if(rightHalf == x){
                operations = Math.min(operations, n-j);
            }if(rightHalf > x) break;
            int index = binarySearch(prefixSum, 0, j-1, x-rightHalf);
            if(index != -1){
                operations = Math.min(operations, index+1+n-j);
            }
        }
        return operations == Integer.MAX_VALUE? -1: operations;
    }
    
    public int binarySearch(int[] arr, int low, int high, int val){
        if(low > high) return -1;
        int mid = low + ((high-low)/2);
        if(arr[mid] == val) return mid;
        else if(arr[mid] > val) return binarySearch(arr, low, mid-1, val);
        else return binarySearch(arr, mid+1, high, val);
    }
}