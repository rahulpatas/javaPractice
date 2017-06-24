package LeetCode;

import java.util.Arrays;
import java.util.List;

public class MaxDistance {

    public static int maxDistance(List<List<Integer>> arrays) {

        List<Integer> listF = arrays.get(0);
        int min = listF.get(0);
        int max = listF.get(listF.size() - 1);
        int diff = 0;

        for(int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);

            if(!list.isEmpty() || list.size() > 0) {
                int aDiff = Math.abs(list.get(0) - max);
                int bDiff = Math.abs(list.get(list.size() -1) - min);
                diff = Math.max(diff, Math.max(aDiff, bDiff));
                min = min < list.get(0) ? min : list.get(0);
                max = max >  list.get(list.size() -1) ? max : list.get(list.size() -1);
            }
        }

        return diff;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(Arrays.asList(1,3),Arrays.asList(-10,-9,2,2,3,4),Arrays.asList(-8,-5,2),
                Arrays.asList(-10,-6,-5,-5,0,3),Arrays.asList(-8,-6,-2,0,2,3,3),Arrays.asList(-10,-10,-5,0));
        maxDistance(arrays);
    }
}
