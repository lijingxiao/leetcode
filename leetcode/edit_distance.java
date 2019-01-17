package leetcode;

/**
 * Created by lijingxiao on 2018/12/21.
 *
 * 动态规划：用dis[i][j]记录string1的前i个和string2的前j个的距离。那么可以知道：

 1.如果str1的第i个，也就是str1[i-1]和str2的第j个也就是str2[j-1]相等的话，那么

 dis[i][j] = dis[i-1][j-1]

 2.如果str[i-1] != str2[j-1]

 　　2.1 通过替换操作把str[i-1]替换成str2[j-1]，那么

 　　　　dis[i][j] = dis[i-1][j-1] + 1;

 　　2.2 通过插入操作在str1后面插入str2[j-1], 那么就相当于计算

 　　　　dis[i][j] = dis[i][j-1] + 1;

 　　2.3 通过插入操作在str2后面插入str1[i-1],那么就是

 　　　　dis[i][j] = dis[i-1][j] + 1;　
 */
public class edit_distance {
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();

        int m = word1.length(), n = word2.length();//d[i][j]表示从word1的[0,i]子串到word2的[0,j]子串的距离
        int[][] d = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            d[i][0] = i;
        for (int i = 0; i <= n; i++)
            d[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) { //word1的i位置的字符等于word2的j位置的字符，那么从d[i-1][j-1]到这一步是不用变化的
                    d[i][j] = d[i-1][j-1];
                } else {//否则，从增，删，改中选择最小的一个进行
                    d[i][j] = Math.min(d[i][j-1] + 1, d[i-1][j] + 1);
                    d[i][j] = Math.min(d[i][j], d[i-1][j-1] + 1);
                }
            }
        }
        return d[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int distance = minDistance(word1, word2);
        System.out.println(distance);
    }
}
