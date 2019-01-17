package leetcode;

/**
 * Created by lijingxiao on 2018/12/26.
 *
 *在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

 题目只有唯一解
 *
 */
public class gas_station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, index = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i + 1;
            }
        }
        if (total < 0)
            return -1;
        else
            return index;
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}
