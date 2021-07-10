class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(newColor == image[sr][sc]) return image;
        
        connected(image, sr, sc, newColor, image[sr][sc]);
        
        return image;
        
    }
    
    
    public void connected(int[][] grid, int i, int j,int color, int oldColor) {
     
        if(i<0 || j<0 || j>=grid[0].length || i>=grid.length || grid[i][j] !=oldColor){
            return;
        }
        
        grid[i][j] = color; 

        connected(grid, i-1, j, color, oldColor);
        connected(grid, i+1, j, color, oldColor);
        connected(grid, i, j-1, color, oldColor);
        connected(grid, i, j+1, color, oldColor);
        
    }
}