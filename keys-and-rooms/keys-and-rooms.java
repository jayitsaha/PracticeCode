class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        
//         Do it for the first node, and let BFS take over, See whether all components connected?
        visited[0] = true;
        
        for(int i: rooms.get(0)){
            queue.add(i);
            visited[i] = true;
        }
        
        while(!queue.isEmpty()){
            
            int temp = queue.poll();
            for(int j: rooms.get(temp)){
                
                if(visited[j] == false){
                    queue.add(j);
                    visited[j] = true;

                }
            }
        }
        
        for(int k=1;k<visited.length;k++){
            if(visited[k] == false) return false;
        }
            
        
        return true;
    }
}