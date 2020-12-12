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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null) return null;
        if(list1.val == a){
            ListNode t = null;
            if(b == a){
                ListNode temp = list2;
                while(temp.next != null) temp = temp.next;
                temp.next = list1.next;
            }else  t = mergeInBetween(list1.next, a, b, list2);
            return list2;
        }
        if(list1.val == b){
            ListNode temp = list2;
            while(temp.next != null) temp = temp.next;
            temp.next = list1.next;
            return list1;
        }
        
        list1.next = mergeInBetween(list1.next, a, b, list2);
        return list1;
    }
}