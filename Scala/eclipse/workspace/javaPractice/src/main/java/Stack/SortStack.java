package Stack;

import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> unsorted) {

        Stack<Integer> sorted = new Stack<Integer>();

        while (!unsorted.isEmpty()) {

            int tmp = unsorted.pop();

            if (!sorted.isEmpty()) {
                if (sorted.peek() < tmp) {
                    while (!sorted.isEmpty()) {
                        unsorted.push(sorted.pop());
                    }
                }
            }
            sorted.push(tmp);
        }

        while (!sorted.isEmpty()) {
            System.out.println(sorted.pop());
        }
    }


    public static void main(String[] args){

        Stack<Integer> ori = new Stack<Integer>();
        ori.push(1);
        ori.push(-1);
        ori.push(-2);
        ori.push(2);
        ori.push(3);

        sort(ori);
    }
}


