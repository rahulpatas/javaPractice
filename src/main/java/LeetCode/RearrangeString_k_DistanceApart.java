package LeetCode;

import java.util.*;

public class RearrangeString_k_DistanceApart {

    public static String rearrangeString(String s, int k) {

        int length = s.length();
        int[] count = new int[26];
        int[] valid = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < length; index++) {
            int candidatePos = findValidMax(count, valid, index);

            if (candidatePos == -1) {
                return "";
            }

            count[candidatePos]--;
            valid[candidatePos] = index + k;
            sb.append((char) ('a' + candidatePos));
        }

        return sb.toString();
    }

    private static int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] > max && index >= valid[i]) {
                max = count[i];
                candidatePos = i;
            }
        }

        return candidatePos;
    }

    public static String rearrangeStringA(String s, int k) {

        if(k <= 1 || s.length() <= 1) {
            return s;
        }
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            counts[index]++;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
                (a, b) -> !Objects.equals(a.getValue(), b.getValue()) ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                Map.Entry<Integer, Integer> entry = new HashMap.SimpleEntry<>(i, counts[i]);
                q.offer(entry);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int n = k;
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

            while (n > 0 && !q.isEmpty()) {
                Map.Entry<Integer, Integer> top = q.poll();
                int num = top.getValue() - 1;
                if (num > 0) {
                    list.add(new HashMap.SimpleEntry<>(top.getKey(), num));
                }

                n--;
                sb.append((char) ('a' + top.getKey()));
            }

            if (n > 0 && !(q.isEmpty() && list.isEmpty())) {
                return "";
            }

            q.addAll(list);
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println("ans : " + rearrangeStringA("abb", 2));
    }
}
