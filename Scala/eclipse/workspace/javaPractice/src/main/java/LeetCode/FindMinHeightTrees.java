package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n==1) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {

            int key = edges[i][0];
            int val = edges[i][1];

            if(edgeMap.containsKey(key)){
                edgeMap.get(key).add(val);
            }else {
                Set<Integer> s1 = new HashSet<>();
                s1.add(val);
                edgeMap.put(key, s1);
            }

            if(edgeMap.containsKey(val)){
                edgeMap.get(val).add(key);
            }else {
                Set<Integer> s1 = new HashSet<>();
                s1.add(key);
                edgeMap.put(val, s1);
            }
        }

        while (edgeMap.size() > 2){

            Map<Integer, Integer> keySet = edgeMap.entrySet().stream().filter(entry -> entry.getValue().size() == 1)
                    .collect(Collectors.toMap(Map.Entry::getKey, a -> a.getValue().iterator().next()));

            for (int key : keySet.keySet()){
                edgeMap.remove(key);
                edgeMap.get(keySet.get(key)).remove(key);
            }
        }

        return new ArrayList<>(edgeMap.keySet());
    }
}
