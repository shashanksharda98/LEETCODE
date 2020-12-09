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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int n = 1;
        while(q.size() != 0){
            int tempcount = 0;
            List<Integer> temp_list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.remove();
                temp_list.add(temp.val);
                if(temp.left != null && temp.right != null){
                    q.add(temp.left);
                    q.add(temp.right);
                    tempcount+=2;
                }else if(temp.right == null && temp.left != null){
                    q.add(temp.left);
                    tempcount++;
                }else if(temp.left == null && temp.right != null){
                    q.add(temp.right);
                    tempcount++;
                }
            }
            n = tempcount;
            ans.add(0, temp_list);
        }
        return ans;
    }
}