package LeetCode;

import java.util.*;

public class AlienDisctionary {

        public static String alienOrder(String[] words) {

            // Step 1: build the graph
            Map<Character, Set<Character>> graph = new HashMap<>();

            for (int i = 0; i < words.length; i++) {

                String curr = words[i];

                for (int j = 0; j < curr.length(); j++) {
                    if (!graph.containsKey(curr.charAt(j))) {
                        graph.put(curr.charAt(j), new HashSet<>());
                    }
                }

                if (i > 0) {
                    connectGraph(graph, words[i - 1], curr);
                }
            }

            // Step 2: toplogical sorting
            StringBuffer sb = new StringBuffer();
            Map<Character, Integer> visited = new HashMap<>();

            for (Map.Entry<Character, Set<Character>> pair : graph.entrySet()) {

                char vertexId = pair.getKey();

                if (!toplogicalSort(vertexId, graph, sb, visited)) {
                    return "";
                }
            }

            return sb.toString();
        }

        private static void connectGraph(Map<Character, Set<Character>> graph, String prev, String curr) {
            if (prev == null || curr == null) {
                return;
            }

            int len = Math.min(prev.length(), curr.length());

            for (int i = 0; i < len; i++) {
                char p = prev.charAt(i);
                char q = curr.charAt(i);
                if (p != q) {
                    if (!graph.get(p).contains(q)) {
                        graph.get(p).add(q);
                    }
                    break;
                }
            }
        }

        private static boolean toplogicalSort(char vertexId, Map<Character, Set<Character>> graph, StringBuffer sb,
                                       Map<Character, Integer> visited) {
            if (visited.containsKey(vertexId)) {
                // visited
                if (visited.get(vertexId) == -1) {
                    return false;
                }
                // already in the list
                if (visited.get(vertexId) == 1) {
                    return true;
                }
            } else {
                // mark as visited
                visited.put(vertexId, -1);
            }

            Set<Character> neighbors = graph.get(vertexId);

            for (char neighbor : neighbors) {
                if (!toplogicalSort(neighbor, graph, sb, visited)) {
                    return false;
                }
            }

            sb.insert(0, vertexId);
            visited.put(vertexId, 1);

            return true;
        }

    public static void main(String[] args){
       System.out.println(alienOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"}));
    }
}
