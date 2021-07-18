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
        
        boolean flag = false;
        while(temp!=null){
           int nextVal = temp.next != null ? temp.next.val : -200;
           if(temp.val != nextVal){
               if(flag == false){
                    ans.next = new ListNode(temp.val);
                    ans = ans.next;
               }
               flag = false;
               
           }
            else{
                flag = true;
            }
               
               
            temp = temp.next;
        }
        
        return start.next;
        
    }
}