package LeetCode;

public class MaxSumSubArray {

    public static int maxSubArray(int[] nums) {

        int sum = nums[0], maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            sum += nums[i];
            sum = sum > nums[i] ? sum : nums[i];

            maxSum = Integer.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args){

        System.out.print(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
