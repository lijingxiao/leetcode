package leetcode;

/**
 * Created by lijingxiao on 2018/12/12.
 *
 * 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class best_time_to_buy_and_sell_stock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int min = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min){//低于买入价
                min = prices[i];
            } else {
                if (profit < prices[i] - min) { //高于卖出价
                    profit = prices[i] - min;
                }
            }

        }
        return profit;
    }

    public static void main(String[] args) {
        int[] num = {7,6,4,3,1};
//        int[] num = {7,1,5,3,6,4};
        int ret = maxProfit(num);
        System.out.println(ret);
    }
}
