package LeetCode;

import java.util.*;

public class LIS {

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int max = 1;

        Comparator<Map.Entry<Integer, Integer>> comparator = new EntryComparator();

        PriorityQueue<Map.Entry<Integer, Integer>> val = new PriorityQueue<>(comparator);

        val.add(new AbstractMap.SimpleEntry<>(1, nums[n - 1]));

        for (int i = n - 2; i >= 0; i--) {

            PriorityQueue<Map.Entry<Integer, Integer>> tmp = new PriorityQueue<>(val);

            max = 1;

            while (!val.isEmpty() && val.peek().getKey() >= max) {

                Map.Entry<Integer, Integer> a = val.poll();

                if (nums[i] < a.getValue() && max <= a.getKey()) {
                    max = a.getKey() + 1;
                }
            }
            tmp.offer(new AbstractMap.SimpleEntry<>(max, nums[i]));
            val = tmp;
        }

        return val.peek().getKey();
    }

    public static class EntryComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {

            Map.Entry<Integer, Integer> a = (Map.Entry<Integer, Integer>) o1;
            Map.Entry<Integer, Integer> b = (Map.Entry<Integer, Integer>) o2;
            return b.getKey() - a.getKey();
        }
    }

    public static int lengthOfLIS1(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] val = new int[n];

        int max = 1;

        for (int i = n - 1; i >= 0; i--) {

            val[i] = 1;

            for (int j = i + 1; j < n; j++) {

                if (nums[j] > nums[i] && val[i] <= val[j]) {

                    if (val[j] >= max) {
                        max = val[j] + 1;
                        break;
                    }

                    val[i] = val[j] + 1;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        lengthOfLIS1(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    }
}
