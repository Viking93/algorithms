/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3 
**/

class Solution {
    public void dfs(int i, int j, boolean [][]visited, char[][] grid){
        if(!visited[i][j] && grid[i][j] != '0'){
            visited[i][j] = true;            
            
            int m = visited.length;
            int n = visited[0].length;
            
            for(int k = -1; k<=1; k++){
                for(int l = -1; l<=1; l++){
                    if((Math.abs(k) != Math.abs(l)) && (i+k >=0 && i+k <m) && (j+l >= 0 && j+l <n) ) {
                        if(!visited[i+k][j+l] && grid[i+k][j+l] != '0'){
                            dfs(i+k,j+l,visited, grid);
                        }
                    }
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        int islands=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j] != '0'){
                    dfs(i,j,visited, grid);
                    islands++;
                }
            }
        }
        
        return islands;
        
    }
}
