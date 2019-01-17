package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lijingxiao on 2018/12/5.
 */
public class merge_intervals {
     public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }


    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        if (intervals == null || intervals.size()== 0)
            return ret;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ret.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            boolean flag = false;
            Interval item = intervals.get(i);
            for (int j = 0; j < ret.size(); j++) {
                Interval tmp = ret.get(j);
                if (tmp.end >= item.start && tmp.end <= item.end) { //[1,3]  [2,6]
                    flag = true;
                    ret.remove(j);
                    ret.add(new Interval(tmp.start, item.end));
                } else if (item.start <= tmp.end && item.end <= tmp.end) { // [1,4]  [2,3]
                    flag = true;
                }
            }
            if (!flag)
                ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

//        intervals.add(new Interval(1, 4));
//        intervals.add(new Interval(2, 3));

//        intervals.add(new Interval(1, 4));
//        intervals.add(new Interval(0, 2));
//        intervals.add(new Interval(3, 5));
        List<Interval> ret = merge(intervals);
        for (Interval interval : ret) {
            System.out.println("[ " + interval.start + " " + interval.end + " ]");
        }
    }

}
