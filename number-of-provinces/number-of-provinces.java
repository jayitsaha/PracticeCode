class Solution {
    public int findCircleNum(int[][] M) {
        
        int ans = getComponents(0,M);
        return ans;
        
    }
    
    public static int getComponents(int ans, int adj_mat[][]){
        
        int v = adj_mat.length;
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(visited[i] == false){
                ans++;
                BFS(adj_mat,i,visited);
            }
        }
        return ans;
    }
    
    public static void BFS(int adj_mat[][], int index, boolean visited[]){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(index);
        visited[index] = true;
        
        int v = adj_mat.length;
        while(!q.isEmpty()){
            int front = q.poll();
            for(int i=0;i<v;i++){
                if(adj_mat[front][i]==1 && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    
    }
    

    
}

