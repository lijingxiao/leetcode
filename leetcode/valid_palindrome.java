package leetcode;

/**
 * Created by lijingxiao on 2019/1/11.
 */
public class valid_palindrome {
    private boolean isNumorLetter(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        else return false;
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isNumorLetter(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        if (s1.length() <= 1) return true;
        int l = 0, r = s1.length() - 1;
        while (l <= r) {
            if (Character.toLowerCase(s1.charAt(l)) == Character.toLowerCase(s1.charAt(r))) {
                l++;
                r--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        valid_palindrome valid_palindrome = new valid_palindrome();
        System.out.println(valid_palindrome.isPalindrome(s));
    }
}
