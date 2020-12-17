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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode n = helper(head, head);
        return;
    }
    
    public ListNode helper(ListNode head, ListNode itr){
        if(itr == null) return head;
        ListNode L = helper(head, itr.next);
        if(L == null || L == itr){
            if(L == itr) itr.next = null;
            return null;
        }
        itr.next = L.next;
        L.next = itr;
        if(L.next.next == itr){
            itr.next = null;
            return null;
        }
        return itr.next;
    }
}