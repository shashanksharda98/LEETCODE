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
    //static int min = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            Stack<TreeNode> st = new Stack<>();
            TreeNode cr = root;
            st.push(cr);
            cr = cr.left;
            int data = 0;
            boolean f = false;
            while(st.size() != 0 || cr != null){
                if(cr == null){
                    TreeNode t = st.pop();
                    if(f && t.val <= data) return false;
                    else{
                        data = t.val;
                        f = true;
                    }
                    data = t.val;
                    cr = t.right;
                }else{
                    st.push(cr);
                    cr = cr.left;
                }
            }
            return true;
    }
}