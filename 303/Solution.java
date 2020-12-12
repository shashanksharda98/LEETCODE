class NumArray {
    
    int[] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
        for(int i = 1; i < arr.length; i++) arr[i] += arr[i-1];
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return arr[j];
        return arr[j] - arr[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */