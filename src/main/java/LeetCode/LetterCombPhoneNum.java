package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombPhoneNum {

    private static Map<Integer, Set<Character>> map = new HashMap<>();

    static {
        Set<Character> set = new HashSet<>();
        set.add('\u0000');

        map.put(1, set);

        set = new HashSet<>();
        Collections.addAll(set, 'a', 'b', 'c');
        map.put(2, set);

        set = new HashSet<>();
        Collections.addAll(set, 'd', 'e', 'f');
        map.put(3, set);

        set = new HashSet<>();
        Collections.addAll(set, 'g', 'h', 'i');
        map.put(4, set);

        set = new HashSet<>();
        Collections.addAll(set, 'j', 'k', 'l');
        map.put(5, set);

        set = new HashSet<>();
        Collections.addAll(set, 'm', 'n', 'o');
        map.put(6, set);

        set = new HashSet<>();
        Collections.addAll(set, 'p', 'q', 'r', 's');
        map.put(7, set);

        set = new HashSet<>();
        Collections.addAll(set, 't', 'u', 'v');
        map.put(8, set);

        set = new HashSet<>();
        Collections.addAll(set, 'w', 'x', 'y', 'z');
        map.put(9, set);

        set = new HashSet<>();
        Collections.addAll(set, ' ');
        map.put(0, set);
    }

    public static List<String> letterCombinations(String digits) {

        List<String> results = new ArrayList<>();

        if(digits.length() == 0){
            return results;
        }

        results.addAll(map.get(Integer.valueOf(digits.substring(0, 1)))
                .parallelStream()
                .map(Object::toString).collect(Collectors.toList()));

        for (int i = 1; i < digits.length(); i++) {

           results = combine(map.get(Integer.valueOf(digits.substring(i, i+1))), results);
        }
        return results;
    }

    private static List<String> combine(Set<Character> c, List<String> results) {

        List<String> tmp = new ArrayList<>();

        c.parallelStream().map(ch -> tmp.addAll(results.stream()
                    .map(s -> s + ch)
                    .collect(Collectors.toList())
            )).count();

        return tmp;
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
