package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lijingxiao on 2019/1/2.
 */
public class course_schedule_ii {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        int[] in = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            in[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                queue.add(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            ret[index++] = poll;
            for (Integer num : graph[poll]) {
                if (--in[num] == 0)
                    queue.add(num);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0)
                return new int[0];
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[][] inp = {{1,0},{2,0},{3,1},{3,2}};
//        int n = 4;
//        int[][] inp = {{1,0},{0,1}};
        int[][] inp = {};
        int n = 1;
        int[] order = findOrder(n, inp);
        System.out.println(Arrays.toString(order));
    }
}
