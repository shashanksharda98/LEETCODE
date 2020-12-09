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
    public List<Integer> inorderTraversal(TreeNode root) {
        // if(root == null){
        //     return new ArrayList<>();
        // }
        // List<Integer> left = inorderTraversal(root.left);
        // left.add(root.val);
        // List<Integer> right = inorderTraversal(root.right);
        // for(Integer ele: right){
        //     left.add(ele);
        // }
        // return left;
        //recursive solution
        Stack<Pair> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        stack.push(new Pair(root, 0));
        while(stack.size() != 0){
            Pair top = stack.peek();
            TreeNode topnode = top.node;
            if(top.state == 0){
                if(topnode.left != null){
                    stack.push(new Pair(topnode.left, 0));
                }
                top.state++;
            }else if(top.state == 1){
                ans.add(topnode.val);
                if(topnode.right != null){
                    stack.push(new Pair(topnode.right, 0));
                }
                top.state++;
            }else{
                stack.pop();
            }
        }
        return ans;
    }
}
//recursive
//...................................................
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         if(root == null){
//             return new ArrayList<>();
//         }
//         List<Integer> left = inorderTraversal(root.left);
//         left.add(root.val);
//         List<Integer> right = inorderTraversal(root.right);
//         for(Integer ele: right){
//             left.add(ele);
//         }
//         return left;
//     }
// }