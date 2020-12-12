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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else{
            if(root.left == null && root.right == null) return null;
            //2. & 3. node to be deleted has only one child
            else if(root.left != null && root.right == null) return root.left;
            else if(root.left == null && root.right != null) return root.right;
            // 4. node to be deleted has two children
            else{
                TreeNode temp = root.right;
                while(temp.left != null) temp = temp.left;
                temp.left = root.left;
                return root.right;
            }
        }
        return root;
    }
}