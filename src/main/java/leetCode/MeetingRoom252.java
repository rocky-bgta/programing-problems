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
        /*
            a.start - b.start: This is the body of the lambda expression.
            It calculates the difference between the start properties of a and b.
            The result of this subtraction determines the order of the elements in the sorted array.
            If the result is negative, it means a comes before b; if it's positive, it means a comes after b;
            if it's zero, the order remains unchanged.
         */


        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        //return false if there is overlapping
        for(int i = 0; i < n - 1; i++){
            int[] meeting1 = intervals[i]; // previous meeting
            int[] meeting2 = intervals[i + 1]; // next meeting
            if(meeting1[1] > meeting2[0]){ // compare previous meeting's end time overlap with next meeting's start time
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
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
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

