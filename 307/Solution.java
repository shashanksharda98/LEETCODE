class NumArray {
    
    int[] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
        for(int i = 1; i < this.arr.length; i++){
            this.arr[i] += this.arr[i-1];
        }
    }
    
    public void update(int i, int val) {
        int diff = 0;
        if(i == 0) diff = val - this.arr[0];
        else{
            diff = val - (this.arr[i] - this.arr[i-1]);
        }
        
        for(int j = i; j < this.arr.length; j++) this.arr[j] += diff;
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return this.arr[j];
        return this.arr[j] - this.arr[i-1];
    }
}
//*****************************************************************************************************
//segment tree implementation
//prefix sum array approach updates in O(n) time whereas the segment tree approach takes log(n) for update function as well as sumRange function
//*****************************************************************************************************


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

