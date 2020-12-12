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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null){
            List<String> ret = new ArrayList<>();
            ret.add("" +root.val);
            return ret;
        }
        List<String> ans = new ArrayList<>(); 
        if(root.left != null){
            List<String> temp1 = binaryTreePaths(root.left);
            for(String ele: temp1){
                ans.add("" + root.val+"->"+ele);
            }
        }
        if(root.right != null){
            List<String> temp1 = binaryTreePaths(root.right);
            for(String ele: temp1){
                ans.add("" + root.val+"->"+ele);
            }
        }
        return ans;
        
    }
}