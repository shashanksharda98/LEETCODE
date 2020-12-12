/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length -1);
    }
    
    public TreeNode helper(int[] nums, int st, int end){
        if(st >= end){
            if(st == end)return new TreeNode(nums[end]);
            return null;
        }
        int temp = Integer.MIN_VALUE, a = 0;
        for(int i = st; i <= end; i++){
            if(nums[i] > temp){
                temp = nums[i];
                a = i;
            }
        }
        TreeNode ret = new TreeNode(nums[a]);
        ret.left = helper(nums, st, a-1);
        ret.right = helper(nums, a+1, end);
        return ret;
    }
}