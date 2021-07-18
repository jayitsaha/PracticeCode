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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode temp = head;
        ListNode ans = new ListNode(-200);
        ListNode start = ans;
        
        
        while(temp!=null){
           int nextVal = temp.next != null ? temp.next.val : -200;
           if(temp.val != nextVal){
               ans.next = new ListNode(temp.val);
               ans = ans.next;
           }
               
               
            temp = temp.next;
        }
        
        return start.next;
        
    }
}