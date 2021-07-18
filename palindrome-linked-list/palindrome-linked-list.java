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
    ListNode pleft;
    public boolean isPal(ListNode head){
        
        if(head == null) return true;
        boolean res = isPal(head.next);
        
        if(res == false) return false;
        else if(pleft.val != head.val) return false;
        else {
            pleft = pleft.next;   
            return true;
        }
    } 
    
    public boolean isPalindrome(ListNode head) {
        pleft = head;
        return isPal(head);
    }
}