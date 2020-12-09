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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int ans = 1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int n = 1;
        while(q.size() != 0){
            int new_n = 0;
            for(int i = 0; i < n; i++){
                TreeNode temp = q.remove();
                if(temp.left == null && temp.right == null) return ans;
                if(temp.left != null){
                    new_n++;
                    q.add(temp.left);
                }
                if(temp.right != null){
                    new_n++;
                    q.add(temp.right);
                }
            }
            ans++;
            n = new_n;
        }
        return 0;
    }
}