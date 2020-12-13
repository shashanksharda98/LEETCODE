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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode new_head = reverseK(head, head, k); // reversing first k nodes and getting the new head
        ListNode temp = head;
        ListNode nxt_group = head.next, crr_tail = head;

        //reversing the next group k nodes 
        while(nxt_group != null){
            ListNode nxt_group_head = reverseK(nxt_group, nxt_group, k);
            if(nxt_group_head == null) break;
            crr_tail.next = nxt_group_head;
            crr_tail = nxt_group;
            nxt_group = crr_tail.next;
        }
        return new_head;
    }
    //reversing k nodes 
    public ListNode reverseK(ListNode head, ListNode itr, int k){
        if(k > 1 && itr.next == null) return null;
        if(k == 1){
            head.next = itr.next;
            return itr;
        }
        ListNode temp = head == itr ? itr.next : null;
        ListNode ret = reverseK(head, itr.next, k-1);
        if(ret == null) return null;
        if(head == itr){
            temp.next = itr;
        }else{
            itr.next.next = itr;
            itr.next = null;
        }
        return ret;
    } 
}