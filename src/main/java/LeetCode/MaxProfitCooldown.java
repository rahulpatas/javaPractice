package LeetCode;

public class MaxProfitCooldown {

    public static int maxProfit(int[] prices) {

        int len = prices.length;

        if(len < 2){
            return 0;
        }

        return maxProfitRem(0,prices);
    }

    public static int maxProfitRem(int index, int[] prices){

        int min = Integer.MIN_VALUE, sumDiff1 = 0, sumDiff2 = 0;

        if(index < prices.length){
            min = prices[index];
        }

        for (int i = index + 1; i < prices.length; i++) {

            if(prices[i] < min){
                min = prices[i];
            }else {
                sumDiff1 += prices[i] - min + maxProfitRem(i+2, prices);

                if(i+1 < prices.length && prices[i+1] > prices[i]){
                    sumDiff2 += prices[i+1] - min + maxProfitRem(i+3, prices);
                }

                break;
            }
        }

        return Integer.max(sumDiff1, sumDiff2);
    }

    public static int maxProfitDay(int[] prices) {

        int pd1=0, pd2=0;

        for(int i=1; i < prices.length; i++){

            int tmp = pd1;
            pd1 = Math.max(pd1 + prices[i] - prices[i-1], pd2);
            pd2 = Math.max(tmp, pd2);
        }
        return Math.max(pd1, pd2);
    }

    public static void main(String[] args){

//        System.out.println(maxProfit(new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2,4,3,4}));
        System.out.println(maxProfitDay(new int[]{1, 2, 3, 0, 2,4,3,4}));
    }

}
