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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(head2);
        return merge(h1, h2);
    }
    public ListNode merge(ListNode h1, ListNode h2){
        
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        ListNode ans = new ListNode(1);
        ListNode nxt = ans;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                nxt.next = h1;
                h1 = h1.next;
                nxt = nxt.next;
                nxt.next = null;
            }else{
                nxt.next = h2;
                h2 = h2.next;
                nxt = nxt.next;
                nxt.next = null;
            }
        }
        if(h1 == null && h2 == null) return ans.next;
        else if(h1 == null && h2 != null){
            nxt.next = h2;
        }else if(h2 == null && h1 != null) nxt.next = h1;
        return ans.next;
    }
}