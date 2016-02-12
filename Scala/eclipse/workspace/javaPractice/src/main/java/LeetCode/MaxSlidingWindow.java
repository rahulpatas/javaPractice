package LeetCode;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length < k || k < 1){
            return new int[0];
        }

        int[] max = new int[nums.length - k + 1];
        int maxVal = Integer.MIN_VALUE, maxIndex = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {

            if (i == 0 || maxIndex == i - 1) {
                maxVal = Integer.MIN_VALUE;

                for (int j = 0; j < k; j++) {

                    if(maxVal < nums[i + j] ){
                        maxVal =  nums[i + j];
                        maxIndex = i + j;
                    }
                }
            }else {
                if(nums[i + k - 1] > maxVal){
                    maxVal = nums[i + k - 1];
                }
            }
            max[i] = maxVal;
        }

        return max;
    }
}
