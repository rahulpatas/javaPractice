package LeetCode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int lastZeroIndex = 0;

        for (int index = 0; index < nums.length; index++) {

            if (nums[index] != val) {
                if (index != lastZeroIndex) {
                    int tmp = nums[lastZeroIndex];
                    nums[lastZeroIndex] = nums[index];
                    nums[index] = tmp;
                }
                lastZeroIndex++;
            }
        }
        return lastZeroIndex;
    }
}
