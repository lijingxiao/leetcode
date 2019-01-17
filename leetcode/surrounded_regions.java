package leetcode;

/**
 * Created by lijingxiao on 2019/1/10.
 */
public class surrounded_regions {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m ; i++) if (board[i][0] == 'O') dfs(board, i, 0);
        for (int i = 0; i < m ; i++) if (board[i][n-1] == 'O') dfs(board, i, n-1);
        for (int j = 0; j < n; j++) if (board[0][j] == 'O') dfs(board, 0, j);
        for (int j = 0; j < n; j++) if (board[m-1][j] == 'O') dfs(board, m-1, j);
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = '1';
        if (i > 0 && board[i-1][j] == 'O') dfs(board, i-1, j);
        if (i < board.length - 1 && board[i+1][j] == 'O') dfs(board, i+1, j);
        if (j > 0 && board[i][j-1] == 'O') dfs(board, i, j-1);
        if (j < board[i].length - 1 && board[i][j+1] == 'O') dfs(board, i, j+1);
    }

    public static void main(String[] args) {
        char[][] b = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        for (int i = 0; i< b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solve(b);
        for (int i = 0; i< b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }
}
