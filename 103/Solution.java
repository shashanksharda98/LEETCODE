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
    
    class pair{
        TreeNode t;
        int lvl;
        public pair(TreeNode cr, int lvl){
            this.t = cr;
            this.lvl = lvl;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<pair> q = new ArrayDeque<>();
        List<List<Integer>> ans = new LinkedList<>();
        pair r = new pair(root, 0);
        q.add(r);
        int level = -1;
        while(q.size() != 0){
            pair crr = q.remove();
            if(crr.t != null){
                int value = crr.t.val;
                int lvl = crr.lvl;
                if(lvl > level){
                    List<Integer> temp = new LinkedList<>();
                    if(lvl % 2 == 0) temp.add(value);
                    else temp.add(0, value);
                    ans.add(temp);
                    level = lvl;
                }else{
                    if(lvl % 2 == 0) ans.get(lvl).add(value);
                    else ans.get(lvl).add(0, value);
                }
                q.add(new pair(crr.t.left, lvl+1));
                q.add(new pair(crr.t.right, lvl+1));
            }
            
        }
        return ans;
        
        
        
        
        
        
        
        
        
        
        
//         Queue<TreeNode> q = new ArrayDeque<>();
//         List<List<Integer>> ans = new ArrayList<>();
//         if(root == null) return ans;
//         q.add(root);
//         int n = 1;
//         int o = 0;
//         while(q.size() != 0){
//             List<Integer> temp = new LinkedList<>();
//             int c = 0;
//             for(int i = 0; i < n; i++){
//                 TreeNode crr = q.remove();
//                 if(crr.left != null){
//                     q .add(crr.left);
//                     c++;
//                 }
//                 if(crr.right != null){
//                     q.add(crr.right);
//                     c++;
//                 }
                
//                 if(o % 2 == 0) temp.add(crr.val);
//                 else temp.add(0, crr.val);
//             }
//             o++;
//             n = c;
//             ans.add(temp);
//         }
        
//         return ans;
    }
    
}