class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int x = nums.length - k;
        reverse(nums, x, nums.length-1);
        reverse(nums, 0, x-1);
        reverse(nums, 0, nums.length-1);
    }
    public static void reverse(int[] arr, int s, int e){
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}