package LeetCode;


import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int n1 = stack.pop(), n2 = stack.pop();
                    stack.push(n2 / n1);
                    break;

                default:
                    stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        evalRPN(new String[]{"3","2","1"});
    }
}
