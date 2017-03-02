package LeetCode;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int lastZeroIndex = 0;

        for (int index = 0; index < nums.length; index++) {

            if (nums[index] != 0) {
                if (index != lastZeroIndex) {
                    int tmp = nums[lastZeroIndex];
                    nums[lastZeroIndex] = nums[index];
                    nums[index] = tmp;
                }
                lastZeroIndex++;
            }
        }
    }
}
