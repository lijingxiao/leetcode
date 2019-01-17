package leetcode;

/**
 * Created by lijingxiao on 2018/11/22.
 */
public class longestPalindrome {
    public static boolean isPalindrome (String s) {
        if (s.length() <1)
            return false;
        boolean ret = false;
        int start = 0, end=s.length()-1;
        while (start <= end) {
            if (start == end) {
                ret = true;
                break;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                ret = false;
                break;
            }
        }
        if (start > end)
            ret = true;
        return ret;
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length()<=1)
            return s;
        int len=0;
        String ret = "";
        for (int i=0;i<s.length();i++) {
            for (int j=i+1;j<s.length();j++) {
                if (isPalindrome(s.substring(i,j))){
                    if ((j-i+1) > len) {
                        len = j-i+1;
                        ret = s.substring(i,j-i+1);
                    }

                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        boolean r1 = isPalindrome("abacdef");
//        System.out.println(r1);
//        boolean r2 = isPalindrome("aa");
//        System.out.println(r2);

        String s = "ccddababc";
        String substring = s.substring(4,3);

        System.out.println(substring);
        boolean is = isPalindrome(s);
        System.out.println(is);
        String ret = longestPalindrome(s);
        System.out.println(ret);

    }
}
