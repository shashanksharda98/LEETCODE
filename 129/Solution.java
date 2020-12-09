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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return ans;
    }
    
    public void helper(TreeNode root, int x){
        if(root == null) return;
        x *= 10;
        x += root.val;
        if(root.left == null && root.right == null){
            ans += x;
            return;
        }
    
        helper(root.left, x);
        helper(root.right, x);
        return;
    }
}