package leetcode;

/**
 * Created by lijingxiao on 2018/11/29.
 *
 * 输入:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。

 动态规划，上边和左边的谁小就用谁
 */
public class minPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        int l = grid.length;
        int h = grid[0].length;
        int[][] d = new int[l][h];
        d[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            d[i][0] = d[i-1][0] + grid[i][0];
        }
        for (int i = 1; i< grid[0].length; i++) {
            d[0][i] = d[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (d[i-1][j] < d[i][j-1]) {
                    d[i][j] = d[i-1][j] + grid[i][j];
                } else {
                    d[i][j] = d[i][j-1] + grid[i][j];
                }
            }
        }
        return d[l-1][h-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int sum = minPathSum(grid);
        System.out.println(sum);
    }
}
