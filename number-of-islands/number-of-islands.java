class Solution {
    public int numIslands(char[][] grid) {
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    connected(grid, i, j, visited);
                    count++;
                }
                
            }
        }
        
        
        return count;
        
    }
    
    public void connected(char[][] grid, int i, int j, boolean[][] visited) {
     
        if(i<0 || j<0 || j>=grid[0].length || i>=grid.length || grid[i][j]=='0' || visited[i][j] == true)
            return;
        visited[i][j] = true;
        connected(grid, i-1, j, visited);
        connected(grid, i+1, j, visited);
        connected(grid, i, j-1, visited);
        connected(grid, i, j+1, visited);
        
    }
}