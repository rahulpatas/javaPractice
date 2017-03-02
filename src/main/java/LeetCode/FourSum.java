package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        if (len < 4) {
            return res;
        }

        Arrays.sort(nums);
        int max = nums[len - 1];

        if (4 * nums[0] > target || 4 * max < target) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];

            if (4 * num > target) {
                return res;
            }

            if (num + 3 * max < target || (i > 0 && num == nums[i - 1])) {
                continue;
            }

            if (i + 3 < len && num == nums[i + 3] && num * 4 == target) {
                res.add(Arrays.asList(num, num, num, num));
                i += 3;
                continue;
            }

            threeSum(nums, i, target - num, res, num);
        }

        return res;
    }

    private static void threeSum(int[] nums, int index, int target, List<List<Integer>> res, int num) {

        int len = nums.length;

        if (index +  1  >= len -1 ) {
            return;
        }

        int max = nums[len - 1];

        for (int i = index + 1; i < nums.length; i++) {

            int cur = nums[i];

            if ((i != index + 1 && cur == nums[i - 1]) || cur + 2 * max < target) {
                continue;
            }

            if (cur * 3 > target) {
                break;
            }

            if (i + 2 < len && cur == nums[i + 2] && cur * 3 == target) {
                res.add(Arrays.asList(num, cur, cur, cur));
                i += 2;
                continue;
            }

            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = cur + nums[j] + nums[k];
                if (sum == target) {
                    res.add(Arrays.asList(num, cur, nums[j], nums[k]));
                }
                if (sum <= target) {
                    while (nums[j] == nums[++j] && j < k) ;
                }
                if (sum >= target) {
                    while (nums[k] == nums[--k] && j < k) ;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        fourSum(a, -1);
    }
}
