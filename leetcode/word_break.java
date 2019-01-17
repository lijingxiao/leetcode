package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2019/1/9.
 */
public class word_break {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] d = new boolean[s.length() + 1];
        d[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (d[j] && wordDict.contains(s.substring(j, i)))
                    d[i] = true;
            }
        }
        return d[d.length -1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean b = wordBreak(s, list);
        System.out.println(b);
    }
}
