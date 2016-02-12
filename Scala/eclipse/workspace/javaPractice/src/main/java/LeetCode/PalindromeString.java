package LeetCode;


import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PalindromeString {

    public boolean isPermutaionPalindrome(String word){

        return word.chars().boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values()
                .stream()
                .filter(p -> p%2 == 1)
                .count() <= 1;

    }

    public boolean isPermutaionPalindrome1(String word){

      Set<Character> chars = new HashSet<>();

        for(char c : word.toCharArray()){

            if(chars.contains(c)){
                chars.remove(c);
            }else {
                chars.add(c);
            }
        }

        return chars.size() <= 1;
    }
}
