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
    public int[] nextLargerNodes(ListNode head) {
        int[] ans = size(head, 0);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < ans.length; i++){
            if(st.size() != 0 && ans[i] > ans[st.peek()]){
                while(st.size() != 0 && ans[i] > ans[st.peek()]){
                    ans[st.peek()] = ans[i];
                    st.pop();
                }
            }
            st.push(i);
        }
        while(st.size() != 0) ans[st.pop()] = 0;
        return ans;
    }
    
    public int[] size(ListNode head, int s){
        if(head == null) return new int[s];
        int[] ret = size(head.next, s+1);
        ret[s] = head.val;
        return ret;
    }
}