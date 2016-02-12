package LeetCode;

public class MaxProfit3 {

    public static int maxProfit(int[] prices) {

        int[] left = new int[prices.length];
        int profit = 0, diff = 0, min = 0;

        for (int i = 0; i < prices.length ; i++) {

            if(i == 0){
                left[0] = 0;
                min = prices[0];
            }else {

                diff = Math.max(prices[i] - min,  diff);
                left[i] = diff;
                min = Integer.min(min, prices[i]);
            }
        }

        diff = 0;

        for (int i = prices.length -1; i >= 0 ; i--) {

            if(i == prices.length -1){
                min = prices[i];
                profit = left[i];

            }else {

                diff = min - prices[i] > diff ?  min - prices[i] : diff;
                min = Integer.max(min, prices[i]);

                profit = Integer.max(profit, diff + left[i]);
            }
        }

        return profit;
    }

    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
    }
}
