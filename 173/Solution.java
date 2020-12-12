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
class BSTIterator {
    
    TreeNode root;
    Stack<Integer> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        helper(root, this.st);
    }
    
    /** @return the next smallest number */
    public int next() {
        return st.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return st.size() != 0;
    }
    
    public void helper(TreeNode root, Stack<Integer> st){
        if(root == null) return;
        helper(root.right, st);
        st.push(root.val);
        helper(root.left, st);
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */