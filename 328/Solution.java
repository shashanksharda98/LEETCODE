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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next;
        ListNode temp = even.next, odd_itr = odd, even_itr = even;
        odd_itr.next = null;
        even_itr.next = null;
        for(int i = 1; temp != null; i++){
            ListNode nxt = temp.next;
            if(i % 2 == 0){
                even_itr.next = temp;
                even_itr = even_itr.next;
                even_itr.next = null;
            }else{
                odd_itr.next = temp;
                odd_itr = odd_itr.next;
                odd_itr.next = null;
            }
            temp = nxt;
        }
        odd_itr.next = even;
        return odd;
    }
}