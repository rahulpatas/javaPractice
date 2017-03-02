package LeetCode;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int index = searchInsert(nums, target);

        if (index == nums.length || nums[index] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{index , searchInsert(nums, target +1) - 1};
        }
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
