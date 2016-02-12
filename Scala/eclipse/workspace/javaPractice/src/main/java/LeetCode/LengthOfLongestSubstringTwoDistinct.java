package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LengthOfLongestSubstringTwoDistinct {

    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty() ||s.length() == 0){
            return 0;
        }

        int maxLen = 0, count = 0;
        Deque<Character> uniqueChar = new LinkedList<>();


        for (int high = 0; high < s.length(); high++) {

            char c = s.charAt(high);

            if(uniqueChar.contains(c)) {
                uniqueChar.add(c);
            }else {
                if (count < 2) {
                    uniqueChar.add(c);
                    count++;
                } else {
                    maxLen = maxLen < uniqueChar.size() ? uniqueChar.size() : maxLen;

                    char first = uniqueChar.peekFirst();
                    Deque<Character> temp = new LinkedList<>();
                    while (uniqueChar.peekLast() == first) {
                        temp.add(uniqueChar.pollLast());
                    }

                    uniqueChar.add(c);
                }
            }
        }

        return maxLen < uniqueChar.size() ? uniqueChar.size() : maxLen;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcbbbbcccbdddadacb"));
    }
}
