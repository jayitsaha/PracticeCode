class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> pascal = new ArrayList<>();
        
        
        List<Integer> first = new ArrayList<>();
        
        first.add(1);
        if(rowIndex == 0) return first;
        
        pascal.add(first);
              
        for(int i=1; i<=rowIndex;i++){
            
            List<Integer> prevRow = pascal.get(i-1);
            List<Integer> current = new ArrayList<>();
            
            current.add(1);
            
            for(int j=1;j<i;j++){
                
                current.add(prevRow.get(j-1) + prevRow.get(j));
            }
            
            current.add(1);
            
            pascal.add(current);
        }
        
        
        return pascal.get(rowIndex);
        
        
        
        
        
    }
}