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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(map, 0, inorder.length -1, postorder, 0, postorder.length -1);
    }
    
    public TreeNode helper(HashMap<Integer, Integer> map, int st, int end, int[] post, int s, int e){
        if(s >= e){
            if(s == e) return new TreeNode(post[s]);
            return null;
        }
        TreeNode t = new TreeNode(post[e]);
        int a = map.get(post[e]);
        //while(in[a] != post[e]) a++;
        t.left = helper(map, st, a -1, post, s, s + (a-st)-1);
        t.right = helper(map, a+1, end, post, s + (a - st), e-1);
        return t;
    }
}