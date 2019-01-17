package leetcode;

/**
 * Created by lijingxiao on 2018/11/25.
 */
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length<1)
            return "";
        if (strs.length == 1)
            return strs[0];

        StringBuilder ret = new StringBuilder();
        int index=0;
        while (true) {
            for (int i=0; i<strs.length; i++) {
                if (strs[i] == null || strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)) {
                    return ret.toString();
                }
            }
            ret.append(strs[0].charAt(index));
            index ++;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String ret = longestCommonPrefix(strs);
        System.out.println(ret);
    }
}
