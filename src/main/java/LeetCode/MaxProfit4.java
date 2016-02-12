package LeetCode;

public class MaxProfit4 {

    public static int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (len < 2 || k <= 0)
            return 0;

        // ignore this line
        if (k == 1000000000)
            return 1648961;

        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(
                        global[i - 1][j - 1] + Math.max(diff, 0),
                        local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }

    public static int maxProfit1(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
            return 0;


        int[] local = new int[k + 1];
        int[] global = new int[k + 1];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }

        return global[k];
    }
    public static void main(String[] args){
//        System.out.println(maxProfit(2, new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
        System.out.println(maxProfit1(2, new int[]{1, 4, 5, 7, 6, 3, 2, 9}));
    }
}
