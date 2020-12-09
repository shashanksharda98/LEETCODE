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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = head;
        for(int i = 0; temp != null; i++, temp = temp.next){
            map.put(i, temp);
        }
        return helper(map, 0, map.size() - 1);
    }
    
    public TreeNode helper(HashMap<Integer, ListNode> map, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode t = new TreeNode(map.get(mid).val, helper(map, start, mid -1), helper(map, mid +1, end));
        return t;
    }
}