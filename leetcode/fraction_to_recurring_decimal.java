package leetcode;

import java.util.HashMap;
import java.util.LongSummaryStatistics;

/**
 * Created by lijingxiao on 2019/1/7.
 */
public class fraction_to_recurring_decimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0) return null;
        StringBuilder builder = new StringBuilder();
        int a = numerator >=0 ? 1 : -1;
        int b = denominator >= 0 ? 1: -1;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long res = num / den;
        String ret = String.valueOf((long)num / den);
        long ref = (num % den) * 10;
        if (a*b == -1)
            builder.append("-");
        builder.append(String.valueOf(res));
        if (ref == 0) return builder.toString();

        builder.append('.');
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        int pos = 0;
        while (ref != 0) {
            if (map.containsKey(ref)) {
                sb.insert(map.get(ref).intValue(), '(');//循环出现的位置，循环的小数可能不止一位，如97/7，所以要记录位置
                sb.append(')');
                break;
            }
            res = ref / den;
            sb.append(String.valueOf(res));
            map.put(ref, pos++);
            ref = ref % den * 10;
        }
        return builder.append(sb).toString();
    }

    public static void main(String[] args) {
        int a = -97;
        int b = 7;
        String s = fractionToDecimal(a, b);
        System.out.println(s);
    }
}
