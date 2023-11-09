package leetCode;

/*
    https://www.youtube.com/watch?v=uOTJITjfz9g
 */

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom252 {

    public boolean canAttendMeetings(int[][] intervals) {
        //base case
        int n = intervals.length;
        if(n == 0) return true;

        //Sort array by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //return false if there is overlapping
        for(int i = 0; i < n - 1; i++){
            int[] meeting1 = intervals[i];
            int[] meeting2 = intervals[i + 1];
            if(meeting1[1] > meeting2[0]){
                return false;
            }
        }
        return true;
    }

}

// another solution:

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int i = 1; i < intervals.length; i++) {
            Interval i1 = intervals[i - 1];
            Interval i2 = intervals[i];
            if (i1.end > i2.start) {
                return false;
            }
        }
        return true;
    }
}

