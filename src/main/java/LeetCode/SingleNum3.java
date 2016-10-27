package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNum3 {

    public static int[] singleNumber(int[] nums) {

        int diff = 0;

        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return

        for (int num : nums) {
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public int[] singleNumber3(int[] nums) {

        if (nums.length == 0){
            return new int[]{0};
        }

        Set<Integer> singleNum = new HashSet<>();

        for (int num : nums) {

            if (!singleNum.add(num)) {
                singleNum.remove(num);
            }
        }

        return singleNum.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));
    }

}
