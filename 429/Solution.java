/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int n = 1;
        while(q.size() != 0){
            List<Integer> temp = new ArrayList<>();
            int c = 0;
            for(int i = 0; i < n; i++){
                Node curr = q.remove();
                temp.add(curr.val);
                c += curr.children.size();
                for(Node ele: curr.children){
                    q.add(ele);
                }
            }
            n = c;
            ans.add(temp);
        }
        return ans;
    }
}