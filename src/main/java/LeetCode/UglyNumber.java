package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

    public static boolean isUgly(int num) {


        List<Long> uglyNum = new ArrayList<>();
        int p2 = 0, p3 = 0, p5 = 0, p = 0;

        uglyNum.add(0, 1L);

        while (uglyNum.get(p) < num) {

            while (uglyNum.get(p2) * 2 <= uglyNum.get(p)) {
                p2++;
            }

            while (uglyNum.get(p3) * 3 <= uglyNum.get(p)) {
                p3++;
            }

            while (uglyNum.get(p5) * 5 <= uglyNum.get(p)) {
                p5++;
            }

            p++;
            uglyNum.add(p, min(uglyNum.get(p2) * 2, uglyNum.get(p3) * 3, uglyNum.get(p5) * 5));
        }

        return uglyNum.get(p) == num;
    }

    private static long min(long a, long b, long c) {
        long tmp = Long.min(a, b);

        return Long.min(tmp, c);
    }

    public static boolean isUgly1(int num) {

        if (num == 1) {
            return true;
        }

        if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num = num / 2;
        }

        while (num % 3 == 0) {
            num = num / 3;
        }

        while (num % 5 == 0) {
            num = num / 5;
        }

        return num == 1;
    }

    public static void main(String[] args) {

        System.out.println(isUgly1(2144678529));
    }
}
