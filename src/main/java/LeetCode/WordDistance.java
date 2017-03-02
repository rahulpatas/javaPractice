package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    Map<String, List<Integer>> wordIndexsMap = new HashMap<>();
    public WordDistance(String[] words) {

        for (int i = 0; i < words.length; i++) {
            List<Integer> indexes = wordIndexsMap.getOrDefault(words[i], new ArrayList<>());
            indexes.add(i);
            wordIndexsMap.put(words[i], indexes);
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> indexes1 = wordIndexsMap.get(word1);
        List<Integer> indexes2 = wordIndexsMap.get(word2);

        int dist = Integer.MAX_VALUE;
        int i = 0;
        int j= 0;

        while (i < indexes1.size() && j < indexes2.size()) {

            int a = indexes1.get(i);
            int b = indexes2.get(j);
            dist = Math.min(dist, Math.abs(b - a));

            if (a > b) {
                j++;
            } else {
                i++;
            }
        }
        return dist;
    }


}
