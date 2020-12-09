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
        
        if(l1 == null && l2 == null) return null;
        
        if(l1 == null && l2 != null){
            if(l2.val >= 10){
                if(l2.next != null){
                    l2.next.val += 1;
                    l2.next = addTwoNumbers(null, l2.next);
                }else l2.next = new ListNode(1);
                l2.val %= 10;
            }
            return l2;
        }else if(l2 == null && l1 != null){
            if(l1.val >= 10){
                if(l1.next != null){
                    l1.next.val += 1;
                    l1.next = addTwoNumbers(l1.next, null);
                }else l1.next = new ListNode(1);
                l1.val %= 10;
            }
            return l1;
        }else{
            l2.val += l1.val;
            if(l2.val >= 10){
                if(l1.next == null && l2.next == null){
                    l2.next = new ListNode(1);
                }else if(l1.next == null && l2.next != null){
                    l2.next.val += 1;
                    l2.next = addTwoNumbers(null, l2.next);
                }else if(l1.next != null && l2.next == null){
                    l1.next.val += 1;
                    l2.next = addTwoNumbers(l1.next, null);
                }else{
                    l2.next.val += 1;
                    l2.next = addTwoNumbers(l1.next, l2.next);
                }
                l2.val %= 10;
            }else l2.next = addTwoNumbers(l1.next, l2.next);
            
            return l2;
        }
        
        
        
        
       
        // ListNode head = new ListNode();
        // ListNode temp = head;
        // int carry = 0;
        // while(l1 != null && l2 != null){
        //     int sum = l1.val + l2.val + carry;
        //     carry = sum/10;
        //     temp.next = new ListNode(sum%10);
        //     temp = temp.next;
        //     l1 = l1.next;
        //     l2 = l2.next;
        // }
        // if(l1 == null && l2 != null){
        //     while(l2 != null){
        //         int sum = l2.val + carry;
        //         carry = sum / 10;
        //         temp.next = new ListNode(sum%10);
        //         temp = temp.next;
        //         l2 = l2.next;
        //     }
        // }else if(l2 == null && l1 != null){
        //     while(l1 != null){
        //         int sum = l1.val + carry;
        //         carry = sum / 10;
        //         temp.next = new ListNode(sum%10);
        //         temp = temp.next;
        //         l1 = l1.next;
        //     }
        // }
        // if(carry != 0) temp.next = new ListNode(1);
        // //temp = null;
        // return head.next;
    }
}