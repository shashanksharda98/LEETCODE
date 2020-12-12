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
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null) return new ListNode[k];
        ListNode[] arr = new ListNode[k];
        int size = getSize(root);
        if(k >= size){
            case1(arr, root);
        }else{
            case2(arr, root, size);
        }
        return arr;
    }
    
    public void case2(ListNode[] arr, ListNode root, int size){
        int rem = size % arr.length;
        int l = size/arr.length;
        for(int i = 0; i < arr.length; i++){
            arr[i] = root;
            int subsize = rem <= 0 ? l : l+1;
            ListNode prev = root;
            for(int j = 0; j < subsize; j++){
                prev = root;
                root = root.next;
            }
            prev.next = null;
            rem--;
        }
        return;
    }
    
    public void case1(ListNode[] arr, ListNode root){
        for(int i = 0; i < arr.length; i++){
            arr[i] = root;
            if(root != null) root = root.next;
            if(arr[i] != null)arr[i].next = null;
        }
        return;
    }
    
    public int getSize(ListNode root){
        if(root == null) return 0;
        return getSize(root.next) + 1;
    }
}