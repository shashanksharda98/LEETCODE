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
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;
        int sum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>(); // prefix sum method, when the sum is repeated updating the list and calling the function again
        while(temp != null){
            sum += temp.val;
            if(sum == 0){
                head = temp.next;
                head = removeZeroSumSublists(head);
                break;
            }
            if(map.containsKey(sum)){
                ListNode start = map.get(sum);
                start.next = temp.next;
                head = removeZeroSumSublists(head);
                break;
            }
            map.put(sum, temp);
            temp = temp.next;
        }
        return head;
    }
}