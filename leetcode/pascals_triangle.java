package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/11.
 *
 * 输入: 5
 输出:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class pascals_triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows < 1)
            return lists;

        for (int i = 0; i< numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            if (i > 0) {
                for (int j = 1; j < i; j++) {
                    tmp.add(lists.get(i-1).get(j-1) + lists.get(i-1).get(j));
                }
                tmp.add(1);
            }
            lists.add(tmp);
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(10);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
