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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null, last = null;
        while(l1 != null && l2 != null){
            ListNode curr = null;
            if(l1.val <= l2.val){
                curr = l1;
                l1 = l1.next;
            }else{
                curr = l2;
                l2 = l2.next;
            }
            
            if(head == null){
                head = curr;
                curr.next = null;
                last = curr;
            }else{
                last.next = curr;
                curr.next = null;
                last = curr;
            }
        }
        if(l1 != null) last.next = l1;
        if(l2 != null) last.next = l2;
        return head;
    }
}