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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;
        while(temp.next != null && temp.val == temp.next.val){
            temp = temp.next;
            //return deleteDuplicates(temp.next);
        }
        if(temp != head) return deleteDuplicates(temp.next);
        head.next = deleteDuplicates(head.next);
        return head;
    }
}