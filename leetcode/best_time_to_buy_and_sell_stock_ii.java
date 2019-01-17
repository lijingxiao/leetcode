package leetcode;

/**
 * Created by lijingxiao on 2019/1/14.
 */
public class best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                profit += (prices[i]-prices[i-1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] num = {7,1,5,3,6,4};
//        int[] num = {1,2,3,4,5};
        best_time_to_buy_and_sell_stock_ii nii = new best_time_to_buy_and_sell_stock_ii();
        System.out.println(nii.maxProfit(num));
    }
}
