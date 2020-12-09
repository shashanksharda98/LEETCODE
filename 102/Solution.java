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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int n = 1;
        while(q.size() != 0){
            List<Integer> temp = new LinkedList<>();
            int new_n = 0;
            for(int i = 0; i < n; i++){
                TreeNode crr = q.remove();
                temp.add(crr.val);
                if(crr.left != null){
                    q.add(crr.left);
                    new_n++;
                }
                if(crr.right != null){
                    q.add(crr.right);
                    new_n++;
                }
            }
            ans.add(temp);
            n = new_n;
        }
        return ans;
    }
}