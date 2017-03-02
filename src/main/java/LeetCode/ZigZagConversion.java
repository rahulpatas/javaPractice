package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        int length = s.length();
        if (numRows == 1 || length <= numRows) {
            return s;
        }

        StringBuffer[] map = new StringBuffer[numRows];

        for (int i = 0; i < numRows; i++) {
            map[i] = new StringBuffer();
        }


        int incre = 1;
        int index = 0;

        for (int i = 0; i < length; i++) {

            map[index].append(s.charAt(i));

            if (index == 0) {
                incre = 1;
            }

            if (index == numRows - 1) {
                incre = -1;
            }

            index += incre;
        }

        for (int i = 1; i < numRows; i++) {
            map[0].append(map[i]);
        }

        return map[0].toString();
    }

    public String convert1(String s, int numRows) {

        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        int x = 2 * (numRows - 1);
        int len = s.length();
        char[] c = new char[len];
        int k = 0;

        for (int i = 0; i < numRows; i++) {

            for (int j = i; j < len; j = j + x) {
                c[k++] = s.charAt(j);

                if (i > 0 && i < numRows - 1 && j + x - 2 * i < len) {
                    c[k++] = s.charAt(j + x - 2 * i);
                }
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {

        System.out.println(convert("ABCD", 2));
    }
}
