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
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k, new ArrayList<>());
    }
    public int helper(TreeNode root, int k, List<Integer> l){
        if(root == null) return 0;
        int a = helper(root.left, k, l);
        if(l.size() == k) return l.get(k-1);
        l.add(root.val);
        if(l.size() == k) return l.get(k-1);
        int b = helper(root.right, k, l);
        if(l.size() == k) return l.get(k-1);
        return 0;
    }
}