package leetcode;

/**
 * Created by lijingxiao on 2019/1/3.
 */
public class count_primes {
    public static int countPrimes(int n) {
        if (n < 2)
            return 0;
        int count = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (flag[i])
                continue;
            count++;
            for (long j = (long)i*i; j < n; j += i) {
                flag[(int)j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 15;
        int p = countPrimes(n);
        System.out.println(p);
    }
}
