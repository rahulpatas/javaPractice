package LeetCode;

import java.util.*;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty() ||s.length() == 0){
            return 0;
        }

        int maxLen = 0;
        Queue<Character> uniqueChar = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(!uniqueChar.contains(c)){
                uniqueChar.add(c);
            }else {
                maxLen = maxLen < uniqueChar.size() ? uniqueChar.size() : maxLen;
                while (uniqueChar.peek() != c){
                    uniqueChar.poll();
                }

                uniqueChar.poll();
                uniqueChar.add(c);
            }
        }

        return maxLen < uniqueChar.size() ? uniqueChar.size() : maxLen;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("bpfbhmipx"));
    }
}
