package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/26.
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 */
public class generate_parentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;
        String str = "";
        dfs(list, str, n, n);
        return list;
    }
    public static List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list;
        ArrayList<String> tmp = new ArrayList<>();
        dfs2(list, tmp, n, n);
        return list;
    }
    private static void dfs2(List<String> list, ArrayList<String> tmp, int left, int right) {
        if (left == 0 && right == 0) {
            StringBuilder builder = new StringBuilder();
            for (String s : tmp) {
                builder.append(s);
            }
            list.add(builder.toString());
            return;
        }
        if (right < left)
            return;

        if (left > 0) {
            tmp.add("(");
            dfs2(list, tmp, left -1, right);
            tmp.remove(tmp.size() - 1);
        }
        if (right > 0) {
            tmp.add(")");
            dfs2(list, tmp, left, right - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    private static void dfs(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (right < left)
            return;

        if (left > 0) {
            dfs(list, str + "(", left -1, right);
        }
        if (right > 0) {
            dfs(list, str + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> strings = generateParenthesis2(n);
//        List<String> strings = generateParenthesis(n);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
