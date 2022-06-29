class Solution {
    int max=0;
    
    public void travelAndCollectGold(int[][] arr, int i, int j, boolean[][]visited, int answer) {

    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true) { //1
        
        max=Math.max(max,answer); 
        return;
    }
    visited[i][j] = true; //2
        
    int val = arr[i][j];   //3
    travelAndCollectGold(arr, i - 1, j, visited, answer+val); //4
    travelAndCollectGold(arr, i, j + 1, visited, answer+val);
    travelAndCollectGold(arr, i, j - 1, visited, answer+val);
    travelAndCollectGold(arr, i + 1, j, visited, answer+val);
    
    visited[i][j] = false;
        

  }
    
    public int getMaximumGold(int[][] arr) {
        
    boolean[][]visited = new boolean[arr.length][arr[0].length]; //1
    for (int i = 0; i < arr.length; i++) { //2
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] != 0) {
          int ans = 0;
          travelAndCollectGold(arr, i, j, visited, ans); //4
         
         
        }
      }
    }
        return max;
    }
}