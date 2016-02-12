package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class balancedPara {

    private static final Map<Character, Character> brackets = new HashMap<Character, Character>();

    static {
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('[', ']');
    }

    public static boolean isBalanced(String a){

        Stack<Character> stack = new Stack<>();
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
                        stack.push(character);
                        i++;
                    } else if (stack.empty() || !character.equals(brackets.get(stack.pop()))) {
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
