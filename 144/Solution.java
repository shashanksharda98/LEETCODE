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
    // public class Pair{
    //     TreeNode node;
    //     int state;
    //     public Pair(TreeNode node, int state){
    //         this.node = node;
    //         this.state = state;
    //     }
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        // if(root == null) return new ArrayList<>();
        // List<Integer> ans = new ArrayList<>();
        // Stack<Pair> stack = new Stack<>();
        // stack.push(new Pair(root, -1));
        // while(stack.size() != 0){
        //     Pair top = stack.peek();
        //     TreeNode topnode = top.node;
        //     if(top.state == -1){
        //         ans.add(topnode.val);
        //         top.state++;
        //     }else if(top.state == 0){
        //         if(topnode.left != null) stack.push(new Pair(topnode.left, -1));
        //         top.state++;
        //     }else if(top.state == 1){
        //         if(topnode.right != null) stack.push(new Pair(topnode.right, -1));
        //         top.state++;
        //     }else{
        //         stack.pop();
        //     }
        // }
        // return ans;
        if(root == null) return new ArrayList<>();
        List<Integer> left =  preorderTraversal(root.left);
        List<Integer> right =  preorderTraversal(root.right);
        List<Integer> ans = left;
        ans.add(0, root.val);
        for(Integer ele: right){
            ans.add(ele);
        }
        return ans;
    }
}