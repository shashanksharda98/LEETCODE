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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper(preorder, 0, preorder.length -1, map, 0, inorder.length -1);
    }
    
    public TreeNode helper(int[] pre, int st, int end, HashMap<Integer, Integer> map, int s, int e){
        if(st >= end){
            if(st == end) return new TreeNode(pre[st]);
            return null;
             
        }
        TreeNode t = new TreeNode(pre[st]);
        int a = map.get(pre[st]);
        //while(in[a] != pre[st]) a++;
        t.left = helper(pre, st+1, st + (a-s), map, s, a-1);
        t.right = helper(pre, st + (a-s) + 1, end, map, a+1, e);
        return t;
    }
}