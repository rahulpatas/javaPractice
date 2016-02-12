import java.util.*;

public class SortedWordMap {

    private static void sortByComparator(Map<String, Integer> unsortedMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

        unsortedMap.clear();

        // Sort list with comparator, to compare the Map values
        Collections.sort(list, (o1, o2) -> {

            if (o1.getValue().equals(o2.getValue())) {
                return (o1.getKey()).compareToIgnoreCase(o2.getKey());
            } else {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        list.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

    }

    private static Map<String, Integer> stringToWordMap(String string){

        Map<String, Integer> wordMap = new HashMap<>();

        for(String word: string.split(" ")){

            if(wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word) +1);
            }else {
                wordMap.put(word, 1);
            }
        }

        return wordMap;
    }

    public static void main(String[] args){

        String string = "ccd ccd ccd ccd ccd ccd acd acd acd acd acd acd bcd bcd bcd bcd bcd bcd c c c c c c d d d d d d d d d d d d d d";

        Map<String, Integer> wordMap = stringToWordMap(string);

        sortByComparator(wordMap);
    }
}
