package leetcode;

/**
 * Created by lijingxiao on 2018/12/21.
 *
 * 动态规划
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class minimum_path_sum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        if (grid[0].length < 1)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[][] d = new int[m][n];
        d[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            d[i][0] = d[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            d[0][i] = d[0][i-1] + grid[0][i];
        }
        for (int i = 1; i< m; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] = grid[i][j] + (d[i-1][j] < d[i][j-1] ? d[i-1][j] : d[i][j-1]);
            }
        }
        return d[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] num = {{1,3,1},{1,5,1},{4,2,1}};
        int sum = minPathSum(num);
        System.out.println(sum);
    }
}
