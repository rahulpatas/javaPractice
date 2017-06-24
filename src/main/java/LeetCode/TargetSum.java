package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {

        return findTargetSumWays(nums, S, 0, 0, new HashMap<>());
    }

    static int findTargetSumWays(int[] nums, int S, int index, int curS, Map<String, Integer> count) {

        String encodeString = index + "->" + curS;
        if (index == nums.length) {
            return curS == S ? 1 : 0;
        }

        if (count.containsKey(encodeString)) {
            return count.get(encodeString);
        }

            int cur = nums[index];

            int add = findTargetSumWays(nums, S, index + 1, curS + cur, count);
            int minus = findTargetSumWays(nums, S, index + 1, curS - cur, count);

            count.put(encodeString, add + minus);
        return add + minus;
    }

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public int findTargetSumWaysFast(int[] nums, int s) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) / 2);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[s];
    }
}
