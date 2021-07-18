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
        
        if(headB == null || headA == null) return null;
        
        ListNode temp = headA;
        while(temp.next !=null) temp = temp.next;
        temp.next = headB;
        
        ListNode res = detectCycle(headA);
        
        temp.next = null;
        
        return res;
        
        
        
    }
    
    
    public static ListNode detectCycle(ListNode head){
        
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        boolean res = false;
        
        while(fast.next !=null && fast.next.next !=null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                res = true;
                break;
                    
            }
        }
        
        if(res == false) return null;
        
        slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            
        }
        
        return slow;
    }
}