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
    private ListNode ans=null;

    public ListNode helperFunc(ListNode node){
        
        if(node.next!=null){
            
            ListNode temp = helperFunc(node.next);
            
            temp.next = node;
            
            return node;
        }
        else{
            
            ans=node;
            return node;
            
        }
        
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        
        helperFunc(head);
        head.next = null;
        
        return ans;
        
    }
}