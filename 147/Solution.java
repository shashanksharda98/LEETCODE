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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head; 
        // ListNode temp = head.next, next_node = head;
        // while(next_node != null){
        //     next_node = temp.next;
        //     head = insert(head, temp);
        //     temp = next_node;
        // }
        // return head;
        ListNode new_head = null;
        while(head != null){
            new_head = insert(new_head, new ListNode(head.val));
            head = head.next;
        }
        return new_head;
    }
    
    public ListNode insert(ListNode head, ListNode x){
        if(head == null) return x;
        if(head.val >= x.val){
            x.next = head;
            return x;
        }
        head.next = insert(head.next, x);
        return head;
    }
    
    // public ListNode insert(ListNode head, ListNode end){
    //     if(head == end) return head;
    //     head.next = insert(head.next, end);
    //     if(head.val >= head.next.val){
    //         ListNode temp = head.next;
    //         head.next = temp.next;
    //         temp.next = head;
    //         return temp;
    //     }
    //     return head;
    // }
}