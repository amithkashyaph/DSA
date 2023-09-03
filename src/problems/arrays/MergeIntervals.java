package problems.arrays;

import java.util.ArrayList;

public class MergeIntervals {

    public static ArrayList<Interval> intervals = new ArrayList<>();

    public static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        int i = 0;
        while(i < intervals.size()) {
            Interval currentInterval = intervals.get(i);
            if(newInterval.end < currentInterval.start) {
                //newInterval lies to the left of the current interval

                break;
            } else if(newInterval.start < currentInterval.end) {
                // this is the overlapping scenario
                newInterval.start = Math.min(newInterval.start, currentInterval.start);
                newInterval.end = Math.max(newInterval.end, currentInterval.end);
            } else {
                ans.add(intervals.get(i));
            }
            i++;
        }
        ans.add(newInterval);

        for(int j = i; j < intervals.size(); j++) {
            ans.add(intervals.get(j));
        }

        return ans;

    }

    public static void main(String[] args) {
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval toBeInserted = new Interval(2, 6);

        ArrayList<Interval> ans = insert(intervals, toBeInserted);

        for(Interval i : ans) {
            System.out.println(i.start + "   " + i.end);
        }
    }
}
