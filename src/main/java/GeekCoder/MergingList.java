package GeekCoder;

import java.util.*;

public class MergingList {

    public static List<Integer> merge(List<Integer> a, List<Integer> b){

        int i =0;

        while (i < a.size() && ! b.isEmpty()){

            if(a.get(i) >= b.get(0)){
                a.add(i, b.get(0));
                b.remove(0);

            }else {

                while (i < a.size() && a.get(i) < b.get(0)){
                    i++;
                }
                a.add(i, b.get(0));
                b.remove(0);
            }

            i++;
        }

        while (!b.isEmpty()){
            a.add(b.get(0));
            b.remove(0);
        }

        return a;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(-1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(8);
        a.add(9000);

        List<Integer> b = new ArrayList<Integer>();
        b.add(20);
        b.add(20);
        b.add(50);
        b.add(60);
        b.add(70);
        b.add(100);

        List<Integer> c = merge(a, b);

        System.out.print(c.toString());
    }
}
