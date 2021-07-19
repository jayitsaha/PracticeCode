/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
//      So copy node.next value to node, point node.next to node's next next , removing temp
        ListNode temp = node.next;
        node.val = node.next.val;
        node.next = node.next.next;
        temp.next = null;
        
        
        
        
        
        
    }
}