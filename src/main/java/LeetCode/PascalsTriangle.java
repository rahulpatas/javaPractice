package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList();

        if(numRows <= 0) {
            return result;
        }

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        result.add(0, l1);

        for (int i = 1; i < numRows; i++) {

            List<Integer> l = new ArrayList<>();
            List<Integer> p = result.get(i - 1);
            l.add(0, 1);

            for (int j = 1; j < i; j++) {
                l.add(j, p.get(j - 1) + p.get(j));
            }

            l.add(i, 1);
            result.add(i, new ArrayList<>(l));
        }

        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> l1 = new ArrayList<>();


        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> l = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    l.add(j, 1);
                } else {
                    l.add(j, l1.get(j - 1) + l1.get(j));
                }
            }

            l1 = l;
        }

        return l1;
    }
}
