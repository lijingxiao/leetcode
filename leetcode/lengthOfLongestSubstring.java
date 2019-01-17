package leetcode;

import java.util.HashSet;

/**
 * Created by lijingxiao on 2018/11/21.
 */
public class lengthOfLongestSubstring {
    /**
     * 滑动窗口start，end
     * 建立HashSet，遍历字符串s，如果set不包含end字符，加入end位置的字符，并end++；
     * 如果包含end位置的字符，将start位置的字符删掉，并start++（加入是abcb这种情况，会持续删除，直到end位置可以加进去）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end=0, ret=0;
        HashSet<Character> set = new HashSet<>();
        while (start<s.length() && end<s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                ret = Math.max(ret, end - start);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int ret = lengthOfLongestSubstring(s);
        System.out.println(ret);
    }
}
