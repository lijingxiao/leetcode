package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lijingxiao on 2019/1/4.
 */
public class largest_number {
    public static String largestNumber(int[] nums) {
        String res = "";
        if (nums == null || nums.length == 0)
            return res;
        String[] nstr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nstr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nstr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (int i = nums.length - 1; i >=0; i--)
            res += nstr[i];
        int i = 0;
        for (; i < nums.length -1; i++) {
            if (res.charAt(i) != '0')
                break;
        }
        return res.substring(i);
    }

    public static void main(String[] args) {
        int[] num = {0,0,0};
//        int[] num = {3,30,34,5,9};
        String s = largestNumber(num);
        System.out.println(s);
    }
}
