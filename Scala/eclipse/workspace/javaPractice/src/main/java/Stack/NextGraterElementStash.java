package Stack;

import java.util.Stack;

public class NextGraterElementStash {

    public static void nextgrEle(int[] elements){
        Stack<Integer> element = new Stack();

        element.push(elements[0]);

        for (int i = 1; i < elements.length; i++) {

            if (!element.isEmpty() && element.peek() < elements[i]) {

                while (!element.isEmpty() && element.peek() < elements[i]) {
                    System.out.println(element.pop() + " -> " + elements[i]);
                }
                element.push(elements[i]);
            }else {
                element.push(elements[i]);
            }
        }

        while (!element.isEmpty()){
            System.out.println(element.pop() + " -> -1");
        }
    }

    public static void main(String[] args){

        nextgrEle(new int[]{4, 5, 2, 25});
        nextgrEle(new int[]{11, 13, 21, 3});
    }
}
