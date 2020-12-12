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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        return merge(l1, l2);
    }
    
    public void inorder(TreeNode r, List<Integer> l){
        if(r == null) return;
        inorder(r.left, l);
        l.add(r.val);
        inorder(r.right, l);
    }
    
    public List<Integer> merge(List<Integer> l1, List<Integer> l2){
        if(l1.size() == 0 && l2.size() != 0) return l2;
        if(l1.size() != 0 && l2.size() == 0) return l1;
        List<Integer> ans = new LinkedList<>();
        while(l1.size() != 0 || l2.size() != 0){
            
            
            if(l1.size() == 0 || l2.size() == 0){
                
                if(l1.size() == 0){
                ans.add(l2.get(0));
                l2.remove(0);
                }else{
                    ans.add(l1.get(0));
                    l1.remove(0);
                }
                
            }else{
                
                if(l1.get(0) < l2.get(0)){
                ans.add(l1.get(0));
                l1.remove(0);
                }else if(l2.get(0) < l1.get(0)){
                    ans.add(l2.get(0));
                    l2.remove(0);
                }else{
                    ans.add(l1.get(0));
                    l1.remove(0);
                }
            
            }
        }
        return ans;
    }
}