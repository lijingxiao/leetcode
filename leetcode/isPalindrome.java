package leetcode;

/**
 * Created by lijingxiao on 2018/11/25.
 */
public class isPalindrome {
    public static boolean isPalindrome3(int x) {
        if (x<0)
            return false;

        int len=1,b=x;
        while (b >= 10){
            len = len*10;
            b = b/10;
        }
        while (x>0) {
            int left=x/len,right=x%10;//获取头和尾

            if (left != right)
                return false;

            //去掉头和尾
            x = x%len;
            x = x/10;
            len = len/100;
        }
        return true;
    }

    /**
     * 将一个数倒置
     * 39.60%
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x<0)
            return false;

        int a=0,b=x;
        while (b>0) {
            a = a*10 + b%10;
            b = b/10;
        }
        if (x == a)
            return true;
        else
            return false;
    }

    /**
     * 耗时太长
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;
        if (x<10)
            return true;
        String xstr = String.valueOf(x);
        int start=0, end=xstr.length()-1;
        boolean ret=true;
        while (start <= end) {
            if (xstr.charAt(start) != xstr.charAt(end)) {
                ret = false;
                break;
            } else {
                start++;
                end--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int x=31;
        boolean res = isPalindrome3(x);
        System.out.println(res);
    }
}
