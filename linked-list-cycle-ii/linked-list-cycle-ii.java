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
    public ListNode detectCycle(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        if(slow == null)
                return null;
        boolean iscycle = false;
        
        while(slow.next !=null && fast.next !=null && fast.next.next !=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                
                iscycle = true;
                break;
            }            
        }
        if(iscycle){
            
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
                
            }
            
            return slow;
        }
        
        return null;
        
    }
}