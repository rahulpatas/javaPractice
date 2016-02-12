package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubString {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> indices = new ArrayList<>();

        int sLen = s.length(), nWords = words.length, wordLen;

        if(sLen <= 0 || nWords ==0 || (wordLen = words[0].length()) == 0){
            return indices;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        Map<String, Integer> currCount = new HashMap<>();

        for (String word: words) {

            if(wordCount.containsKey(word)){
                wordCount.replace(word, wordCount.get(word) + 1);
            }else {
                wordCount.put(word, 1);
            }
        }

        int start, x, wordsLen = nWords * wordLen;
        String test, temp;

        for (int i = 0; i < wordLen; i++) {

            start = i;
            currCount.clear();

            if(start + wordsLen > sLen){
                return indices;
            }

            for (int j = i; j <= sLen - wordLen ; j += wordLen) {
                test = s.substring(j, j + wordLen);

                if(wordCount.containsKey(test)){

                    if(!currCount.containsKey(test)){
                        currCount.put(test, 1);
                        start = found(indices, start, wordsLen, j, wordLen, currCount, s);
                    }else {
                        x = currCount.get(test);

                        if(x < wordCount.get(test)){
                            currCount.put(test, currCount.get(test) + 1);
                            start = found(indices, start, wordsLen, j, wordLen, currCount, s);
                        }else {

                            while (!(temp = s.substring(start, start + wordLen)).equals(test)){
                                start += wordLen;
                                decreaseCount(currCount, temp);
                            }

                            start += wordLen;

                            if (start + wordsLen > sLen) {
                                break;
                            }
                        }
                    }
                }else {

                    start = j + wordLen;

                    if(start + wordsLen > sLen){
                        break;
                    }

                    currCount.clear();
                }
            }
        }

        return indices;
    }

    public static int found(List<Integer> indices, int start, int wordsLen, int j, int wordLen,
                                 Map<String, Integer> currCount, String s) {
        if (start + wordsLen == j + wordLen) {
            indices.add(start);
            decreaseCount(currCount, s.substring(start, start + wordLen));
            return start + wordLen;
        }
        return start;
    }

    public static void decreaseCount(Map<String, Integer> currCount, String key) {

        int x = currCount.get(key);
        if (x == 1)
            currCount.remove(key);
        else
            currCount.put(key, x - 1);
    }

    public static void main(String[] args) {
//        System.out.println(findSubstring("foobarfoobar", new String[]{"foo", "bar"}));
//        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
//        System.out.println(findSubstring("ababaab", new String[]{ "ab","ba", "ba"}));
//        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("abcabac", new String[]{"ab", "ac"}));
    }
}
