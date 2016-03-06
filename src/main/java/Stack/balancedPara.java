package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class balancedPara {


    public static boolean isBalanced(String s) {

        int i = 0;

        if (s != null) {
            if (s.length() == 0) {
                return false;
            } else if (s.length() % 2 != 0) {
                return false;
            } else {

                Map<Character, Character> brackets = new HashMap<>();

                brackets.put('{', '}');
                brackets.put('(', ')');
                brackets.put('[', ']');

                Stack<Character> stack = new Stack<>();

                for (Character character : s.toCharArray()) {
                    if (brackets.containsKey(character)) {
                        stack.push(character);
                        i++;
                    } else if (stack.empty() || !character.equals(brackets.get(stack.pop()))) {
                        return false;
                    }
                }
                if (i == s.length()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        isBalanced(null);
        assertEquals(false, isBalanced("[["));
        assertEquals(true, isBalanced("{}([])"));
        assertEquals(false, isBalanced("([}])"));
        assertEquals(true, isBalanced("([])"));
        assertEquals(true, isBalanced("()[]{}[][]"));
    }
}
