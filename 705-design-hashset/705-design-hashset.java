class MyHashSet {
    int n = 1000001;
    ArrayList<Integer> arr = new ArrayList<>(n);
    public MyHashSet() {
    }
    
    public void add(int key) {
        if(!arr.contains(key))
            arr.add(key);
        
    }
    
    public void remove(int key) {
         
        arr.remove(Integer.valueOf(key));
        
        
    }
    
    public boolean contains(int key) {
        if(arr.contains(key)){
            return true;
        }
            
        return false;
    }
 
}