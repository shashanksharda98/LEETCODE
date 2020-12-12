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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        //finding the mid point of the list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reversing the second half of the list
        ListNode prev = null, rev = slow, temp = slow;
        while(temp != null){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            rev = temp;
            temp = nxt;
        }
        //checling for pallindorme 
        while(head != null && rev != null){
            if(head.val != rev.val) return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
}