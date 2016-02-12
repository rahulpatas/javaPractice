package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class FindMinHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();

        if (n==1) {
            res.add(0);
            return res;
        }

        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        int[] count = new int[n];

        for (int[] edge : edges) {

            int key = edge[0];
            int val = edge[1];

            count[key]++;
            count[val]++;

            Set<Integer> s1 = edgeMap.getOrDefault(key, new HashSet<>());
            s1.add(val);
            edgeMap.put(key, s1);

            Set<Integer> s = edgeMap.getOrDefault(val, new HashSet<>());
            s.add(key);
            edgeMap.put(val, s);
        }

        Queue<Integer> keySet = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if(count[i] == 1){
                keySet.add(i);
            }
        }

        while (!keySet.isEmpty()){

            res = new ArrayList<>();

            int num = keySet.size();

            for (int i = 0; i < num; i++) {
                int key = keySet.poll();
                count[key]--;
                res.add(key);

                for (int val : edgeMap.get(key)) {

                    if(count[val] == 0){
                        continue;
                    }
                    if (count[val] == 2) {
                        keySet.offer(val);

                    }
                    count[val]--;
                }
            }
        }

        return res;
    }

    public static List<Integer> findMinHeightTrees1(int n, int[][] edges) {


        if (n==1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        int[] count = new int[n];

        for (int[] edge : edges) {

            int key = edge[0];
            int val = edge[1];
            count[key]++;
            count[val]++;

            Set<Integer> s1 = edgeMap.getOrDefault(key, new HashSet<>());
            s1.add(val);
            edgeMap.put(key, s1);

            Set<Integer> s = edgeMap.getOrDefault(val, new HashSet<>());
            s.add(key);
            edgeMap.put(val, s);
        }

        List<Integer> keySet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(count[i] == 1){
                keySet.add(i);
            }
        }
//        List<Integer> keySet = edgeMap.entrySet().stream().filter(entry -> entry.getValue().size() == 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());


        while (n > 2) {

            List<Integer> newLeaves = new ArrayList<>();

            for (int key : keySet) {

                int val = edgeMap.get(key).iterator().next();
                edgeMap.remove(key);
                edgeMap.get(val).remove(key);
                n--;

                if(edgeMap.get(val).size() == 1){
                 newLeaves.add(val);
                }
            }

            keySet = newLeaves;
        }

        return keySet;
    }

    public static void main(String[] args){
        System.out.println(findMinHeightTrees1(4, new int[][]{{0, 1}, {1,2},{1,3}}));
    }
}
