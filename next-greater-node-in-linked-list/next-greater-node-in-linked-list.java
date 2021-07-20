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
    
    static int[] reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
 
        /*printing the reversed array*/
        return a;
    }
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode p = head;
        
        Stack<Integer> st1 = new Stack<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(p!=null){
            
            arr.add(p.val);
            p = p.next;
            
        }
        // Collections.reverse(arr);
        int[] finalArr = new int[arr.size()];
        int j=0;
        for(int i=arr.size() -1;i>=0;i--){
            if(st1.size() == 0)
                finalArr[j] = 0;
            else if(st1.size() > 0 && (arr.get(i) < st1.peek()))
                finalArr[j] = st1.peek();
            else if(st1.size() > 0 && (arr.get(i) >= st1.peek())){
                
                while(st1.size() > 0 && arr.get(i) >= st1.peek()){
                    st1.pop();
                }
                
                if(st1.size() ==0)
                    finalArr[j] = 0;
                else
                    finalArr[j] = st1.peek();
            }
            
            st1.push(arr.get(i));
            j++;
        }
        
        return reverse(finalArr,arr.size());
        
        
    }
}