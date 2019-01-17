package leetcode;

/**
 * Created by lijingxiao on 2019/1/3.
 */
public class number_of_islands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0)
            return 0;
        int m = grid.length,n = grid[0].length,count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '0';
        if (i > 0 && grid[i-1][j] == '1')
            dfs(grid, i-1, j, m, n);
        if (i < m-1 && grid[i+1][j] == '1')
            dfs(grid, i+1, j, m, n);
        if (j > 0 && grid[i][j-1] == '1')
            dfs(grid, i, j-1, m, n);
        if (j < n-1 && grid[i][j+1] == '1')
            dfs(grid, i, j+1, m, n);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numIslands(grid);
        System.out.println(i);
    }
}
