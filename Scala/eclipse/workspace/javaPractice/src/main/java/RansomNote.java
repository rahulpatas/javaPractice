import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static boolean isNotePossible(String note, String article){

        Map<Character, Integer> noteMap = new HashMap<>();

        for(Character c : note.toCharArray()){
            if(noteMap.containsKey(c)){
                noteMap.replace(c, noteMap.get(c) + 1);
            }else {
                noteMap.put(c, 1);
            }

        }

        for (Character c : article.toCharArray()){

           if (!noteMap.isEmpty()) {
               if (noteMap.containsKey(c)) {
                   int value = noteMap.get(c);

                   if (value != 1) {
                       noteMap.replace(c, value - 1);
                   } else {
                       noteMap.remove(c);
                   }
               }
           }else {
               return true;
           }
        }

        return noteMap.isEmpty();
    }

    public static boolean isNotePossible2(String note, String article){

        boolean possible = true;

        for(Character c : note.toCharArray()){
            if(article.indexOf(c) != -1){
                article = article.replaceFirst(String.valueOf(c), "");
            }else {
                possible = false;
                break;
            }
        }

        return possible;
    }
    public static void main(String[] args){

        System.out.println(isNotePossible("is it is", " yes it is is"));
        System.out.println(isNotePossible2("is it is", " yes it is i"));
    }
}
