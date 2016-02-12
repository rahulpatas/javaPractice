package GeekCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NearByWords {

    public static Set<Character> getNearByChar(Character c){
        Set<Character> nearChar = new HashSet<>();

        if (c == 'g'){
            nearChar.add('g');
            nearChar.add('h');
            nearChar.add('f');
        }else {
            nearChar.add('i');
            nearChar.add('o');
            nearChar.add('k');
        }

        return nearChar;
    }

    static Set<String> nearByWords(String input){

        Map<Character, Set<Character>> nearCharMap = new HashMap<>();

       for(Character c : input.toCharArray()){
           nearCharMap.put(c, getNearByChar(c));
       }

        Set<String> subWords = new HashSet<>();
        subWords.add("");

       for( Set<Character> ch : nearCharMap.values()) {
           subWords = permutations(subWords, ch);
       }

        return subWords;
    }

    public static Set<String> permutations(Set<String> subWords, Set<Character> nearByChar){
        Set<String> permutations = new HashSet<>();

        for (String sub : subWords){
            permutations.addAll(nearByChar.stream().map(c -> sub + c).collect(Collectors.toList()));
        }

        return permutations;
    }

    public static void main(String[] args){
        nearByWords("gi").forEach(System.out::println);
    }
}
