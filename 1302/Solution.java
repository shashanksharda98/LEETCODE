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
    int lv = -1, sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode root, int lvl){
        if(root == null) return;
        if(lvl > lv){
            lv = lvl;
            sum = root.val;
        }else if(lvl == lv) sum += root.val;
        helper(root.left, lvl+1);
        helper(root.right, lvl+1);
        return;
    }
}