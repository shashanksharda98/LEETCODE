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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int lvl = 0, n = 1;
        while(q.size() != 0){
            int new_n = 0;
            if(lvl % 2 == 0){
                int cr = Integer.MIN_VALUE;
                for(int i = 0; i < n; i++){
                    TreeNode temp = q.remove();
                    if( temp.val <= cr || temp.val % 2 == 0) return false;
                    
                    if(temp.left != null){
                        new_n++;
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        new_n++;
                        q.add(temp.right);
                    }
                    cr = temp.val;
                }
            }else{
                int cr = Integer.MAX_VALUE;
                for(int i = 0; i < n; i++){
                    TreeNode temp = q.remove();
                    if(cr <= temp.val || temp.val % 2 != 0) return false;
                    
                    if(temp.left != null){
                        new_n++;
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        new_n++;
                        q.add(temp.right);
                    }
                    cr = temp.val;
                }
            }
            n = new_n;
            lvl++;
        }
        return true;
    }
}