package LeetCode;


import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];

        for(char c : tasks) {
            int index = c - 'A';
            counts[index]++;
        }

        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
                (a,b) -> !Objects.equals(a.getValue(), b.getKey()) ? b.getValue() - a.getValue() : 0);

        for(int i = 0; i < counts.length; i++) {
            if(counts[i] > 0) {
                Map.Entry<Integer, Integer> entry = new HashMap.SimpleEntry<>(i, counts[i]);
                q.offer(entry);
            }
        }


        int count = 0;

        while (!q.isEmpty()) {
            int k = n + 1;

            int[] tmp = new int[26];

            while (k > 0 && !q.isEmpty()) {
                Map.Entry<Integer, Integer> top = q.poll();
                tmp[top.getKey()] = top.getValue() - 1;
                k--;
                count++;
            }

            for (int i = 0; i < 26; i++) {

                if (tmp[i] > 0) {
                    q.add(new HashMap.SimpleEntry<>(i, tmp[i])); // add valid tasks
                }
            }

            if (q.isEmpty()) {
                break;
            }

            count = count + k;
        }

        return count;
    }

    public static void main(String[] args) {
        int a = leastInterval(new char[] {'A','A','A','A','A','A','B','C','D','E','F','G'}, 2);
        int b = 0;
    }
}
