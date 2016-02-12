package LeetCode;

public class MaxProduct {

    public static int maxProduct(int[] nums) {

        int max = 1, min = 1, globalMax = Integer.MIN_VALUE;

        for (int num1 : nums) {

            int num = num1;

            if (num == 0) {

                max = 1;
                min = 1;
            } else if (num < 0) {

                num *= min;
                min = max * num1;
                max = num > 0 ? num : 1;
            } else {

                min = min < 0 ? min * num : 1;
                max *= num;
            }

            globalMax = Integer.max(globalMax, num);
        }

        return  globalMax;
    }

    public static void main(String[] args){

//        System.out.println( maxProduct(new int[]{6,3,-10,0,2}));
//        System.out.println( maxProduct(new int[]{0, 2}));

        System.out.println( maxProduct(new int[]{0, -2}));
    }
}
