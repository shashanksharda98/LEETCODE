class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            int k = 0;
            for(int num: nums2){
                nums1[k++] = num;
            }
            return;
        }
        
        for(int num: nums2){
            int k = 0;
            for(int i = m-1; i >= 0; i--){
                if(nums1[i] >= num){
                    nums1[i+1] = nums1[i];
                }else{
                    k = i+1;
                    break;
                }
            }
            nums1[k] = num;
            m++;
        }
        return;
    }
}