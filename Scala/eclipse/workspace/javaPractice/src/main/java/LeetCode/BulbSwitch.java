package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BulbSwitch {

    public static int bulbSwitch(int n) {

        List<Integer> bulbs = new ArrayList<>();
        int a = 1;

        while (a <= n){
            bulbs.add(1);
            a++;
        }

        a = 2;
        while (a <= n) {

            for (int i = 1; i * a - 1  < n; i++) {
                bulbs.set(i * a - 1, bulbs.get(i * a - 1) == 0 ? 1 : 0);
            }
            a++;
        }

        return bulbs.parallelStream().reduce(0, Integer :: sum);
    }

    public static int bulbSwitch1(int n){
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args){
        System.out.println(bulbSwitch(25));
        System.out.println(bulbSwitch1(24));
    }
}
