/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        if(slow == null)
                return false;
        
        while(slow.next !=null && fast.next !=null && fast.next.next !=null){
            
            if(slow == fast.next){
                
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        return false;
        
    }
}