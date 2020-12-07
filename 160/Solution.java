/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int a = getSize(headA);
        int b = getSize(headB);
        if(a > b){
            for(int i = 0; i < a-b; i++) headA = headA.next;
            while(headA != null){
                if(headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        }else if(b > a){
            for(int i = 0; i < b-a; i++) headB = headB.next;
            while(headA != null){
                if(headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        }else{
            while(headA != null){
                if(headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
    
    public int getSize(ListNode head){
        if(head == null) return 0;
        return getSize(head.next) + 1;
    }
}