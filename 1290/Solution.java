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
    //static int m = 1;
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        for(;head != null; head = head.next){
            ans = (ans << 1);
            ans |= head.val;
        }
        return ans;
        
    }
}