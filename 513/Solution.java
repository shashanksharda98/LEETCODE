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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int n = 1;
        int ans = 0;
        while(q.size() != 0){
            int new_n = 0;
            for(int i = 0; i < n; i++){
                TreeNode temp = q.remove();
                if(i == 0) ans  = temp.val;
                if(temp.left != null){
                    new_n++;
                    q.add(temp.left);
                }
                if(temp.right != null){
                    new_n++;
                    q.add(temp.right);
                }
            }
            n = new_n;
        }
        return ans;
    }
}