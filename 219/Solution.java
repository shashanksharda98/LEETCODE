class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0) return false;
        if(k == 0) return false;
        HashSet<Integer> hm = new HashSet<>();
        int i = 0, j = 0;
        hm.add(nums[i]);
        for(j = i+1; j - i <= k && j < nums.length; j++){
            if(hm.contains(nums[j])) return true;
            hm.add(nums[j]);
        }
        while(j < nums.length){
            hm.remove(nums[i++]);
            if(hm.contains(nums[j])) return true;
            hm.add(nums[j]);
            j++;
        }
        return false;
    }
}