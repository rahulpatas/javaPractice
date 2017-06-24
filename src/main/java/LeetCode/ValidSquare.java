package LeetCode;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer, Integer> map = new HashMap<>();

        int d1 = getDist(p1, p2);
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        d1 = getDist(p1, p3);
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        d1 = getDist(p1, p4);
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        d1 = getDist(p2, p3);
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        d1 = getDist(p2, p4);
        map.put(d1, map.getOrDefault(d1, 0) + 1);
        d1 = getDist(p3, p4);
        map.put(d1, map.getOrDefault(d1, 0) + 1);

        if(map.size() == 2 ) {

            int arm = 0;
            int dig = 0;

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){

                int a = entry.getKey();
                int b = entry.getValue();
                if(b == 4) {
                    arm = a;
                }

                if(b == 2) {
                    dig = a;
                }
            }

            return dig != 0 && dig == 2 * arm;
        }

        return false;
    }

    private static int getDist(int[] p1, int[] p2) {
        int x= p1[0] - p2[0];
        int y= p1[1] - p2[1];

        return x * x + y * y;
    }
    public static void main(String[] args) {
        validSquare(new int[]{0,0},
                new int[]{1,1},
                new int[]{0,0},
                new int[]{0,0} );
    }
}
