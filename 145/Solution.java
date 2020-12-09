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
    public class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        // if(root == null) return new ArrayList<>();
        // List<Integer> left = postorderTraversal(root.left);
        // List<Integer>right = postorderTraversal(root.right);
        // for(Integer ele: right){
        //     left.add(ele);
        // }
        // left.add(root.val);
        // return left;
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        while(stack.size() != 0){
            Pair  top = stack.peek();
            TreeNode topnode = top.node;
            if(top.state == 0){
                if(topnode.left != null){
                    stack.push(new Pair(topnode.left, 0));
                }
                top.state++;
            }else if(top.state == 1){
                if(topnode.right != null){
                    stack.push(new Pair(topnode.right, 0));
                }
                top.state++;
            }else{
                ans.add(topnode.val);
                stack.pop();
            }
        }
        return ans;
    }
}