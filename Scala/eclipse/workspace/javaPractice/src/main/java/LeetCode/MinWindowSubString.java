package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

    public static String minWindow(String s, String t) {

        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }

        int min = Integer.MAX_VALUE, count = 0, begin = -1, end = 0;

        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> curChars = new HashMap<>();


        for (char c : t.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        for (int high = 0, low  = 0; high < s.length(); high++) {

            char c = s.charAt(high);

            if( chars.containsKey(c)){

                if(!curChars.containsKey(c)) {
                    curChars.put(c, 1);
                    count++;
                }else {
                    curChars.put(c, curChars.get(c) +1);
                    if(curChars.get(c) <= chars.get(c)){
                        count++;
                    }
                }
                if (count == t.length()){

                    while (!chars.containsKey(s.charAt(low))
                            || curChars.get(s.charAt(low)) > chars.get(s.charAt(low))){

                        if(chars.containsKey(s.charAt(low))
                                && curChars.get(s.charAt(low)) > chars.get(s.charAt(low))) {

                            curChars.put(s.charAt(low), curChars.get(s.charAt(low)) - 1);
                        }

                        low++;
                    }

                    if (high - low + 1 < min) {
                        min = high - low + 1;
                        begin = low;
                        end = high;
                    }
                }
            }
        }

        if(begin == -1){
            return "";
        }
        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("bdab", "ab"));
    }
}
