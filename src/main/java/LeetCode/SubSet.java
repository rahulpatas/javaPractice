package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        subsetsWithDup(nums, 0, result, cur);

        return result;
    }

    private static void subsetsWithDup(int[] nums, int p, List<List<Integer>> result, List<Integer> cur) {

        int len = nums.length;

        if(p <= len) {
            result.add(cur);
        }


        while (p < len) {
            cur.add(nums[p]);
            subsetsWithDup(nums, p + 1, result, new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            p++;

            while(p < len && nums[p] == nums[p -1]) {
                p++;
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,2};

        subsetsWithDup(a);
    }
}
