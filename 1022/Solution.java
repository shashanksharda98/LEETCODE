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
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }
    public int sum(TreeNode root, int n){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return ((n << 1) | root.val);
        }
        return sum(root.left, ((n << 1) | root.val) ) + sum(root.right,((n << 1) | root.val) );
    }
}