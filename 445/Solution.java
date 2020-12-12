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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while(l1 != null || l2 != null){
            if(l1 != null){
                s1.push(l1);
                l1 = l1.next;
            }
            if(l2 != null){
                s2.push(l2);
                l2 = l2.next;
            } 
        } 
        ListNode head = null;
        int carry = 0;
        while(s1.size() > 0 || s2.size() > 0){
            int a = s1.size() == 0? 0 : s1.pop().val;
            int b = s2.size() == 0? 0 : s2.pop().val;
            int sum = a + b + carry;
            carry = sum/10;
            sum %= 10;
            ListNode temp = new ListNode(sum, head);
            head = temp;
        }
        if(carry != 0){
            ListNode temp = new ListNode(1, head);
            head = temp;
        }
        return head;
    }
}