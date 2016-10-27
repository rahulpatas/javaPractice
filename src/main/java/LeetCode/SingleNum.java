package LeetCode;

import java.util.*;

public class SingleNum {

    public static int singleNumber(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        Set<Integer> singleNum = new HashSet<>();

        for (int num : nums) {

            if (!singleNum.add(num)) {
                singleNum.remove(num);
            }
        }

        return singleNum.iterator().next();
    }

    public int singleNumber1 (int[] nums){

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }
}
