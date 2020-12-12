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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int n = 1;
        while(q.size() != 0){
            double avg = 0;
            int temp = 0;
            for(int i = 0; i < n; i++){
                TreeNode curr = q.remove();
                avg += curr.val;
                if(curr.left != null){
                    temp++;
                    q.add(curr.left);
                }
                if(curr.right != null){
                    temp++;
                    q.add(curr.right);
                }
            }
            avg /= n;
            n = temp;
            ans.add(avg);
        }
        return ans;
    }
}