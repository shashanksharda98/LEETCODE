/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int size = getSize(head);
        k = k % size;
        if(k != 0){
            ListNode temp = head, itr = head;
            for(int i = 1; i <= size - k; i++){
                if(i == size - k){
                    rotate(itr.next, head);
                    head = itr.next;
                    itr.next = null;
                    return head;
                }
                itr = itr.next;
            }
        }
        return head;
    }
    
    public void rotate(ListNode itr, ListNode head){
        if(itr.next == null){
            itr.next = head;
            return;
        }
        rotate(itr.next, head);
    }
    
    public int getSize(ListNode head){
        if(head == null) return 0;
        return getSize(head.next) + 1;
    }
}