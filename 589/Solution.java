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
    public class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, -1));
        while(stack.size() != 0){
            Pair top = stack.peek();
            Node topnode = top.node;
            if(top.state == -1){
                ans.add(topnode.val);
                top.state++;
            }else if(top.state > -1 && top.state < topnode.children.size()){
                stack.push(new Pair(topnode.children.get(top.state), -1));
                top.state++;
            }else if(top.state == topnode.children.size()){
                stack.pop();
            }
        }
        return ans;
    }
}