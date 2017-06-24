package LeetCode;

import java.util.*;

public class SmallestFactor {

    public static int smallestFactorization(int a) {

        int[] factors = {2, 3, 5, 7};
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> numCount = new HashMap<>();

        for(int factor : factors) {
            while(a % factor == 0) {
                a = a / factor;
                map.put(factor, map.getOrDefault(factor, 0) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int factor : factors) {
            int count;
            if (map.containsKey(factor)) {
                count = map.get(factor);
                switch (factor) {
                    case 2:
                        while(count >= 3) {
                            numCount.put(8, numCount.getOrDefault(8, 0) + 1);
                            count -= 3;
                        }

                        while(count > 0) {
                            numCount.put(2, numCount.getOrDefault(2, 0) + 1);
                            count--;
                        }
                        break;
                    case 3:
                        while(count >= 2 ) {
                            numCount.put(8, numCount.getOrDefault(8, 0) + 1);
                            count -= 2;
                        }

                        if(count > 0) {
                            int i = list.contains(2) ? 6 : 3;
                            list.add(i);
                            if(i == 6) {
                                list.remove(2);
                            }
                        }
                        break;
                    default :
                        while(count > 0) {
                            list.add(factor);
                            count--;
                        }
                        break;
                }
            }
        }

        int ans = 0;

        if(list.size() > 0) {

            list.sort(Comparator.comparingInt(t -> t));
            int index = 0;
            if( list.size() > 1 && list.get(1) == 2) {
                ans = 4;
                index = 2;
            } else {
                ans = list.get(0);
                index = 1;
            }

            for(int i = index; i < list.size(); i++) {
                ans = 10 * ans + list.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        smallestFactorization(48);
    }
}
