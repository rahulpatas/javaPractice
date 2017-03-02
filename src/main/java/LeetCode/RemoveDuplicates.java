package LeetCode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int lastZeroIndex = 1;

        for (int index = 1; index < len; index++) {
            int val = nums[index - 1];

            if (nums[index] != val) {

                nums[lastZeroIndex] = nums[index];

                lastZeroIndex++;
            } 
        }
        return lastZeroIndex;
    }
}
