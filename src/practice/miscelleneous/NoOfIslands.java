package practice.miscelleneous;

import java.util.Arrays;

public class NoOfIslands {
	
	
	
    static boolean isSafe(char[][] grid, int row, int column, boolean[][] visited) {
    	return row>=0 && row<grid.length && column>=0 && column<grid[0].length && grid[row][column]=='1' && !visited[row][column];
    }
	
	public static int numIslands(char[][] grid) {
		int noOfIslands=0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for(boolean[] row:visited) {
			Arrays.fill(row, false);
		}
        for(int i=0;i<grid.length;i++) {
        	for(int j=0;j<grid[0].length;j++) {
            	if(grid[i][j]=='1' && !visited[i][j]) {
            		
            		dfs( grid, i, j,  visited);
            		noOfIslands++;
            		
            	}
            }
        }
		
		
		return noOfIslands;
    }
	
	public static void dfs(char[][] grid, int row, int column, boolean[][] visited) {
		
		visited[row][column]=true;
		// right cell
		if(isSafe(grid, row, column+1, visited))
		dfs(grid, row, column+1, visited);
		// left cell
		if(isSafe(grid, row, column-1, visited))
		dfs(grid, row, column-1, visited);
		// top cell
		if(isSafe(grid, row-1, column, visited))
		dfs(grid, row-1, column, visited);
		// buttom cell
		if(isSafe(grid, row+1, column, visited))
		dfs(grid, row+1, column, visited);
						
		
	}
	public static void main(String[] args) {
		
	char[][] grid = {
			 {'1','1','1','1','0'},
			 {'1','1','0','1','0'},
	         {'1','1','0','0','0'},
	         {'0','0','0','0','0'}
		};
	System.out.println(numIslands(grid));
	
	char[][] grid2 = {
			  {'1','1','0','0','0'},
			  {'1','1','0','0','0'},
			  {'0','0','1','0','0'},
			  {'0','0','0','1','1'}
		};
	System.out.println(numIslands(grid2));
}
}
