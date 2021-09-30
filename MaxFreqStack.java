/* Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned
*/

class FreqStack {

    HashMap<Integer , Stack<Integer>> map1 = new HashMap<>();
    HashMap<Integer , Integer> map2 = new HashMap<>();
    int maxFreq=-1;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        map2.put(val , map2.getOrDefault(val , 0)+1);
        int freq = map2.get(val);
        maxFreq = Math.max(maxFreq , freq);
        if(!map1.containsKey(freq)){
            map1.put(freq , new Stack<Integer>());
           
        }
        map1.get(freq).push(val);
        
    }
    
    public int pop() {
        int ans = map1.get(maxFreq).pop();
        if(map1.get(maxFreq).isEmpty()==true){
            //map1.remove(maxFreq);
            maxFreq--;
        }
       
        map2.put(ans , map2.get(ans)-1);
        
        return ans;
        
    }
}
