package leetcode;

/**
 * Created by lijingxiao on 2019/1/4.
 */
public class number_of_1_bits {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        if (n == 0 || n == 1)
            return n;

        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 11;
        int i = hammingWeight(n);
        System.out.println(i);
    }
}
