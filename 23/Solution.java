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
    public ListNode mergeKLists(ListNode[] lists) {
        //if(lists.length == 0) return null;
        // PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new NC());
        // for(int i = 0; i < lists.length; i++){
        //     ListNode temp = lists[i];
        //     if(temp != null) pq.add(temp);
        // }
        // ListNode ans = new ListNode(1);
        // ListNode dummy = ans;
        // while(pq.size() != 0){
        //     ListNode cr = pq.poll();
        //     if(cr.next != null) pq.add(cr.next);
        //     dummy.next = cr;
        //     dummy = dummy.next;
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode temp: lists){
            ListNode temp1 = temp;
            while(temp1 != null){
                pq.add(temp1.val);
                temp1 = temp1.next;
            }
        }
        ListNode dummy = new ListNode(1);
        ListNode ans = dummy;
        while(pq.size() != 0){
            if(ans == null) ans = new ListNode(pq.poll());
            else{
                ans.next = new ListNode(pq.poll());
                ans = ans.next;
            }
        }
        return dummy.next;
        
        //return ans.next;
    }
    
    // class NC implements Comparator<ListNode>{
    //     public int compare(ListNode n1, ListNode n2){
    //         if(n1.val > n2.val) return 1;
    //         else if(n1.val < n2.val) return -1;
    //         return 0;
    //     }
    // }
}