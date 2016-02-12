package LeetCode;


public class MinSubArrayLen {

    public static int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int len = Integer.MAX_VALUE, sum = 0;

        for (int  high = 0, low = 0; high < nums.length; high++) {

            if (sum < s) {
                sum += nums[high];
            }

            if(sum >= s){

                while (low <= high && sum >= s) {
                    len = len > high - low + 1 ? high - low + 1: len;
                    sum -= nums[low];
                    low++;
                }
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args){
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
