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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        helper(root, 0);
        return ans;
    }
    
    public void helper(TreeNode root, int lvl){
        if(root == null) return;
        if(ans.size() -1 < lvl) ans.add(root.val);
        else{
            ans.add(lvl, Math.max(ans.get(lvl), root.val));
            ans.remove(lvl+1);
        }
        helper(root.left, lvl+1);
        helper(root.right, lvl+1);
    }
}