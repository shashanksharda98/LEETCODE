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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode temp = head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode left_itr = left, right_itr = right;
        while(temp != null){
            ListNode nxt = temp.next;
            if(temp.val < x){
                left_itr.next = temp;
                left_itr = left_itr.next;
            }else{
                right_itr.next = temp;
                right_itr = right_itr.next;
            }
            temp.next = null;
            temp = nxt;
        }
        left = left.next;
        right = right.next;
        if(left == null) return right;
        if(right == null) return left;
        left_itr.next = right;
        return left;
    }
}