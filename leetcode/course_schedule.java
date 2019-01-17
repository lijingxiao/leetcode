package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lijingxiao on 2018/12/27.
 *
 * [1,0] 表示从 0 -> 1, 此时1的入度加1
 *
 * 第一种解法：BFS
 * 数组in[] 记录每个节点的入度，graph[]为图的邻接表，queue中保存入度为0的节点
 * 从queue中取出入度为0的节点，不断删除，每删除一个，其目的节点的入度减1，知道queue为空
 * 如果最后还有入度不为0的节点，那么必有环
 *
 *
 * 第二种解法：DFS
 * visit数组记录节点的访问状态，0表示未访问，1表示已经访问（节点及其后续节点都安全），-1表示正在访问
 * dfs时先将节点置为-1，表示正在访问，如果在访问的过程中，遇到了一个同样正在访问的节点，证明有环，返回false；
 * 如果没有冲突，那么将节点状态置为1，表示已经安全访问过
 *
 * 出度为0的节点，不会进行dfs，visit会直接置为1
 *
 */
public class course_schedule {

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph  = new ArrayList[numCourses];
        int[] visit = new int[numCourses];
        for (int i = 0; i< numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i< prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i< numCourses; i++) {
            if (!canFinishDfs(graph, visit, i))
                return false;
        }
        return true;
    }

    private static boolean canFinishDfs(List<Integer>[] graph, int[] visit, int n) {
        if (visit[n] == -1) return false;
        if (visit[n] == 1) return true;

        visit[n] = -1;
        for (Integer node : graph[n]) {
            if (!canFinishDfs(graph, visit, node)) return false;
        }
        visit[n] = 1;
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<Integer>[] graph  = new ArrayList[numCourses];

        for (int i = 0; i< numCourses; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++) { //初始化节点入度，以及图的邻接表
            in[prerequisites[i][0]] ++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i< numCourses; i++) { //入度为0的节点入队
            if (in[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer a = queue.poll();
            for (Integer b : graph[a]) { //删除入度为0的点的出边，目的节点的入度减1
                if (--in[b] == 0)
                    queue.add(b);
            }
        }

        for (int i = 0; i< numCourses; i++) {
            if (in[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] inp = {{0,1},{2,3},{1,2},{1,3}};
//        int[][] inp = {{1,0}};
//        int[][] inp = {{1,0}, {0,1}};
        int n = 4;
        boolean b = canFinish2(n, inp);
//        boolean b = canFinish(n, inp);
        System.out.println(b);
    }
}
