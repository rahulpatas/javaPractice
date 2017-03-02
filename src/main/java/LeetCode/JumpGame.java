package LeetCode;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int max = 0;

        for (int i = 0; i < nums.length; i++) {


            if (i > max) {
                return false;
            }

            max = Math.max(nums[i] + i, max);
        }

        return true;
    }

    public boolean canJumpFaster(int[] nums) {

        if(nums.length < 2) {
            return true;
        }

        for(int curr = nums.length-2; curr>=0; curr--) {

            if(nums[curr] == 0){
                int neededJumps = 1;

                while(neededJumps > nums[curr]) {
                    neededJumps++;
                    curr--;

                    if(curr < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
