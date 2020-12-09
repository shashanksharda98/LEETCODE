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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            List<List<Integer>> t = new LinkedList<>();
            return t;
            
        }
        if(root.left == null && root.right == null){
            if(sum == root.val){
                List<Integer> t = new LinkedList<>();
                t.add(root.val);
                List<List<Integer>> r = new LinkedList<>();
                r.add(t);
                return r;
            }
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> ret1 = pathSum(root.left, sum - root.val);
        List<List<Integer>> ret2 = pathSum(root.right, sum - root.val);
        List<List<Integer>> ans = new LinkedList<>();
        if(ret1 != null){
            for(List<Integer> c: ret1){
                c.add(0, root.val);
                ans.add(c);
            }
        }
        if(ret2 != null){
            for(List<Integer> c: ret2){
                c.add(0, root.val);
                ans.add(c);
            }
        }
        return ans;
    }
}