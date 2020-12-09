class Solution {
    public void nextPermutation(int[] nums) {
        int run_max = -1;
        int[] f = new int[101];
        for(int i = nums.length -1; i >= 0; i--){
            if(nums[i] >= run_max){
                run_max = nums[i];
                f[nums[i]]++;
            }else{
                int s = i, temp = nums[i];
                f[temp]++;
                for(int c = temp+1; c <= 100; c++){
                    if(f[c] != 0){
                        nums[s++] = c;
                        f[c]--;
                        break;
                    }
                }
                for(int c = 0; c <= 100 && s < nums.length; c++){
                    while(f[c] != 0){
                        nums[s++] = c;
                        f[c]--;
                    }
                }
                return;
            }
        }
        
        int a = 0, b = nums.length - 1;
        while(a < b){
            int temp = nums[a];
            nums[a++] = nums[b];
            nums[b--] = temp;
        }
        return;
    }
}