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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        return reverse(head, 1, m, n, null);
    }
    
    public ListNode reverse(ListNode head, int i, int m, int n, ListNode strt){
        if(i == n){
            if(head.next == null) return head;
            strt.next = head.next;
            head.next = null;
            return head;
        }
        strt = i == m ? head : strt;
        ListNode nxt = i == m ? head.next : null;
        ListNode ret = null;
        if(i >= m) ret = reverse(head.next, i+1, m, n, strt);
        else head.next = reverse(head.next, i+1, m, n, strt);
        if(i >= m){
            if(i == m){
                nxt.next = head;
                if(nxt == head.next) head.next = null;
                return ret;
            }
            head.next.next = head;
            head.next = null;
            return ret;
        }
        return head;
    }
}