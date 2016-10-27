package LeetCode;

public class IncreasingTripletSubsequence {

    private static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        boolean[] numTwo = new boolean[nums.length];

        for (int i = 1; i < nums.length -1; i++) {

            int j = i + 1;
            boolean has = false;
            while (j < nums.length & !has){
                has = nums[j] > nums[i];
                j++;
            }

            numTwo[i] = has;
        }

        for (int i = 0; i < nums.length - 2 ; i++) {

            int j = i + 1;

            while (j < nums.length -1) {

                if (nums[i] < nums[j] && numTwo[j]) {
                    return true;
                }

                j++;
            }

        }

        return false;
    }

    public static boolean increasingTriplet1(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        increasingTriplet1(new int[] {5, 6, 2, 1, 4, 3});
    }

}
