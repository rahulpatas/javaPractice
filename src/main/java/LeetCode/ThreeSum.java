package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len - 2; i++) {

            if(nums[i]>0) break;

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int first = nums[i];

            for (int j = i + 1; j <= len - 1; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int second = nums[j];
                int third = 0 - first - second;

                if (map.containsKey(third) && map.get(third) > j) {
                    ans.add(Arrays.asList(first, second, third));
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (sum <= 0) {
                    while (nums[j] == nums[++j] && j < k) ;
                }
                if (sum >= 0) {
                    while (nums[k] == nums[--k] && j < k) ;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};

        threeSum1(a);
    }
}
