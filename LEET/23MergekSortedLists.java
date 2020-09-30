/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null)
            return new ListNode();
        ListNode[] ptr = new ListNode[lists.length];
        for(int i=0; i<lists.length; i++)
        {
            ptr[i] = lists[i];
        }
        ListNode head = new ListNode();
        head = null;
        ListNode cur = head;
        int min=-1;  //to store index of least value among all lists
        int val = Integer.MAX_VALUE;
        int flag = 0;
        
        while(flag!=1)
        {
            val = Integer.MAX_VALUE;
            min=-1;
            for(int i=0; i<lists.length; i++)   //get minimum value
            {
                if(ptr[i]!=null)
                {
                    if(val>ptr[i].val)
                    {
                        val = ptr[i].val;
                        min = i;
                    }
                }  
            }
            if(val==Integer.MAX_VALUE && min==-1)   //all linked lists travelled
            {
                flag=1;
                break;
            }
            
            ListNode temp = new ListNode(val);
            ptr[min] = ptr[min].next;
            if(head==null)
            {
                head = temp;
                cur = head;
            }
            else
            {
                cur.next = temp;
                cur = temp;
            }
            
        }
        
        return head;
    }
}
