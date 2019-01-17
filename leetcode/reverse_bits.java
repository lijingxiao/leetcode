package leetcode;

/**
 * Created by lijingxiao on 2019/1/4.
 */
public class reverse_bits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        if (n == 0)
            return n;
        int r = 0;
        for (int i = 0; i < 32; i++) {
            r += n & 1;//取出最低位（0|1），将其填充到r的最低位
            n >>= 1;
            if (i < 31)
                r <<= 1;
        }
        return r;
    }

    public static void main(String[] args) {
//        int n = 43261596;
        int n = 1;
        int i = reverseBits(n);
        System.out.println(i);
    }
}
