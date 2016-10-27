package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SingleNum2 {

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> numCount = new HashMap<>();

        int result = 0;

        for (int num : nums) {

            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        for (int num : numCount.keySet()){
            if (numCount.get(num) < 3){
              result = num;
                break;
            }
        }

        return result;
    }
}
