package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        if(intervals.size() < 2){
            return intervals;
        }

        java.util.Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval first = intervals.get(0);
        List<Interval> merged = new ArrayList<>();

        for (int i = 1; i < intervals.size() ; i++) {

            Interval cur = intervals.get(i);

            if(first.end >= cur.start){
                if(first.end <= cur.end) {
                    first.end = cur.end;
                }
            }else {
                merged.add(first);
                first = cur;
            }
        }
        merged.add(first);
        return merged;
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}