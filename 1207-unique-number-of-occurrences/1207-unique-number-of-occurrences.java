class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            if(!map.containsKey(x)){
                map.put(x,1);
            }
            else{
                map.put(x, map.get(x)+1);
            }
        }
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            arrList.add(entry.getValue());
        }
        
        HashSet<Integer> hs = new HashSet<>(arrList);

        return arrList.size() == hs.size();
    }
        
    }
