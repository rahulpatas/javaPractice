package LeetCode;

public class HouseRobber {

    public static int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int t1 = nums[0], t2 = Math.max(nums[0], nums[1]), t3;

        for(int i = 2; i < nums.length; i++) {

            t3 = Math.max(t1 + nums[i], t2);
            t1 = t2;
            t2 = t3;
        }

        return t2;
    }

    public static void main(String[] args){

        rob(new int[]{1,1});
    }
}
