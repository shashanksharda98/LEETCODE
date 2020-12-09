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
    public class pair{
        boolean ans;
        int h;
        public pair(boolean a, int h){
            this.ans = a;
            this.h = h;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).ans;
    }
    
    public pair helper(TreeNode root){
        if(root == null){
            return new pair(true, 0);
        }
        pair left = helper(root.left);
        pair right = helper(root.right);
        if(left.ans && right.ans){
            if(Math.abs(left.h - right.h) <= 1) return new pair(true, Math.max(left.h, right.h) + 1);
        } 
        return new pair(false, 0);
    }
}