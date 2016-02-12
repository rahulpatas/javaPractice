package LeetCode;

public class MaxProfit {

    public static int maxProfit1(int[] prices) {

        int  sumDiff = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                sumDiff += prices[i] - prices[i-1];
        }
        return sumDiff;
    }

    public static void main(String[] args){

        System.out.println(maxProfit1(new int[]{2,4,1}));
    }
}
