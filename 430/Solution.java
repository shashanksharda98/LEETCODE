/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        List<Node> li = new LinkedList<>();
        flat(head, li);
        return head;
    }
    
    public void flat(Node head, List<Node> li){
        if(head == null) return;
        Node temp = head;
        Node pre = head;
        for(;temp != null; temp = temp.next){
            if(temp.child != null){
                if(temp.next != null)li.add(temp.next);
                temp.next = temp.child;
                temp.child = null;
                temp.next.prev = temp;
                flat(temp.next, li);
            }
            pre = temp;
        }
        if(li.size() != 0){
            pre.next = li.get(li.size() - 1);
            li.remove(li.size() - 1);
            pre.next.prev = pre;
        }
        return;
    }
}