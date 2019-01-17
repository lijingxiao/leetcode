package leetcode;

/**
 * Created by lijingxiao on 2018/11/22.
 */
public class reverse {
    /**
     * 如果ret > Integer.MAX_VALUE/10，ret*10之后肯定会溢出
     * 如果ret< Integer.MIN_VALUE/10，*10之后也会溢出
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x/10 == 0)
            return x;

        int ret=0;
        while (x!= 0) {
            if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE && x%10>7))
                return 0;
            if (ret< Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE &&x%10<-8))
                return 0;
            ret = ret*10 + x%10;
            x= x/10;
        }

        return ret;
    }

    public static void main(String[] args) {
        int num = 1534236469;
        System.out.println(String.format("%f", Math.pow(2,32)-1));
        int ret = reverse(num);
        System.out.println(ret);
    }
}
