package LeetCode;

import java.util.*;

public class FindLadders {

    public static boolean isConnected = false;

    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> fwd = new HashSet<>();
        Set<String> bwd = new HashSet<>();

        fwd.add(beginWord);
        bwd.add(endWord);

        Map<String, Set<String>> hs = new HashMap<>();
        BFS(fwd, bwd, wordList, false, hs);

        if(!isConnected) return result;

        List<String> temp = new ArrayList<>();
        temp.add(beginWord);

        DFS(result, temp, beginWord, endWord, hs);

        return result;
    }


    private static void BFS(Set<String> forward, Set<String> backward, Set<String> wordList, boolean swap, Map<String, Set<String>> hs){

        if(forward.isEmpty() || backward.isEmpty()){
            return;
        }

        if(forward.size()> backward.size()){
            BFS(backward, forward, wordList, !swap, hs);
            return;
        }

        wordList.removeAll(forward);
        wordList.removeAll(backward);

        Set<String> setGen = new HashSet<>();

        for(String s : forward){

            for (int i = 0; i < s.length(); i++) {
                char[] ary = s.toCharArray();
                for (char j = 'a'; j <= 'z' ; j++) {

                    ary[i] = j;
                    String modified = new String(ary);

                    if(!backward.contains(modified) && !wordList.contains(modified)){
                        continue;
                    }

                    String key = !swap ? s : modified;
                    String val = swap ? s : modified;

                    if(!hs.containsKey(key)){
                        hs.put(key, new HashSet<>());
                    }

                    hs.get(key).add(val);

                    if(backward.contains(modified)){
                        isConnected = true;
                    }

                    if(wordList.contains(modified)){
                        setGen.add(modified);
                    }
                }
            }
        }

        if(!isConnected){
            BFS(setGen, backward, wordList, swap, hs);
        }
    }

    public static void DFS(List<List<String>> result, List<String> temp, String start, String end, Map<String, Set<String>> hs){

        if(start.equals(end)){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(!hs.containsKey(start)){
            return;
        }

        for(String s : hs.get(start)){
            temp.add(s);
            DFS(result, temp, s, end, hs);
            temp.remove(temp.size()-1);

        }
    }
    public static void main(String[] args){

        Set<String> s = new HashSet<>();
        Collections.addAll(s, "hot", "dot", "dog", "lot", "log");

        System.out.println(findLadders("hit", "cog", s));

        Set<String> a = new HashSet<>();
        Collections.addAll(a, "a", "b", "c");

        System.out.println(findLadders("a", "c", a));
    }
}
