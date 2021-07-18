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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        
    
        ListNode ans = new ListNode(-1, head);
        ListNode slow = ans;
        
        while (n-- > 0) {
            fast = fast.next;
        }
        
        while(fast !=null){
            fast = fast.next;
            slow = slow.next;
            
        }
        
        slow.next = slow.next.next;
        
        
        return ans.next;
        
        
            
    }
}