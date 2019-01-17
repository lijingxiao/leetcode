package leetcode;

import java.util.HashSet;

/**
 * Created by lijingxiao on 2019/1/3.
 */
public class happy_number {
    public static boolean isHappy(int n) {
        if (n < 1)
            return false;

        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int tmp = 0;
            while (n != 0) {
                int num = n%10;
                tmp += num * num;
                n = n/10;
            }
            n = tmp;
        }
        return n==1;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }
}
