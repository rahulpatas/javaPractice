package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        if (n == 0) {
            result.add("");
        } else {

            for (int i = n - 1; i >= 0; i--) {

                List<String> insertSub = generateParenthesis(i);
                List<String> tailSub = generateParenthesis(n - 1 - i);

                for (String insert : insertSub) {

                    result.addAll(tailSub.stream()
                            .map(tail -> "(" + insert + ")" + tail)
                            .collect(Collectors.toList()));
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
