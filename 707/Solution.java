class MyLinkedList {
    
    Node head;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(this.size == 0 || index >= this.size || index < 0) return -1;
        return getHelper(this.head, index);
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
        return;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(this.size, val);
        return;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size) return;
        this.head = addHelper(this.head, index, new Node(val));
        this.size++;
        return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(this.size == 0 || index < 0 || index >= this.size) return;
        this.head = deleteHelper(this.head, index);
        this.size--;
        return;
    }
    
    public int getHelper(Node head, int i){
        if(i == 0) return head.val;
        return getHelper(head.next, i-1);
    }
    
    public Node addHelper(Node head, int idx, Node v){
        if(idx == 0){
            v.next = head;
            return v;
        }
        head.next = addHelper(head.next, idx-1, v);
        return head;
    }
    
    public Node deleteHelper(Node head, int idx){
        if(idx == 0) return head.next;
        head.next = deleteHelper(head.next, idx-1);
        return head;
    }
}

class Node{
    int val;
    Node next;
    
    public Node(){
        
    }
    public Node(int val){
        this.val = val;
        this.next = null;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */