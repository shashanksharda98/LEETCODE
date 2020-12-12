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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        int n = 0;
        if(root != null){
            q.add(root);
            n = 1;
        }
        while(q.size() != 0){
            int t = 0;
            for(int i = 0; i < n; i++){
                TreeNode temp = q.remove();
                if(i == n-1) ans.add(temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                    t++;
                }
                if(temp.right != null){
                    q.add(temp.right);
                    t++;
                }
            }
            n = t;
        }
        return ans;
    }
}