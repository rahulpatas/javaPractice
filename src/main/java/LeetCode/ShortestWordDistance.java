package LeetCode;

public class ShortestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {

        int index = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];

            if (curWord.equals(word1) || curWord.equals(word2)) {
                if (index != -1 && !words[index].equals(curWord)) {
                    minDist = Math.min(minDist, i - index);
                }

                index = i;
            }
        }

        return minDist;
    }
}
