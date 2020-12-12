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
class FindElements {
    TreeNode root;
    HashSet<Integer> val;

    public FindElements(TreeNode root) {
        this.root = root;
        this.val = new HashSet<>();
        recover(this.root, this.val);
    }
    
    public boolean find(int target) {
        return val.contains(target);
    }
    
    public void recover(TreeNode root, HashSet<Integer> val){
        if(root == null) return;
        if(root.val == -1) root.val = 0;
        int x = root.val;
        val.add(x);
        if(root.left != null) root.left.val = 2 * x + 1;
        if(root.right != null) root.right.val = 2 * x + 2;
        recover(root.left, val);
        recover(root.right, val);
        return;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */