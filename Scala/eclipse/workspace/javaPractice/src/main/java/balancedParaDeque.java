
import java.util.*;

import static org.junit.Assert.assertEquals;

public class balancedParaDeque {

    private static final Map<Character, Character> brackets = new HashMap<>();

    static {
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('[', ']');
    }

    public static boolean isBalanced(String a){

        Deque<Character> deque = new LinkedList<>();

        int i = 0;

        if(a !=null) {
            if ( a.length() == 0) {
                System.out.println("string does not have any character");
                return false;
            } else if (a.length() % 2 != 0) {
                return false;
            } else {

                for (Character character : a.toCharArray()) {
                    if (brackets.containsKey(character)) {
                        deque.push(character);
                        i++;
                    } else if (deque.isEmpty() || !character.equals(brackets.get(deque.pop()))) {
                        return false;
                    }
                }
                if(i == a.length()){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){

        isBalanced(null);
        assertEquals(false, isBalanced("[["));
        assertEquals(true, isBalanced("{}([])"));
        assertEquals(false,isBalanced("([}])"));
        assertEquals(true, isBalanced("([])"));
        assertEquals(true, isBalanced("()[]{}[][]"));
    }
}
