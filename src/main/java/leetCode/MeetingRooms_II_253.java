package leetCode;

/*
    Given an array of meeting time intervals intervals where
    intervals[i] = [starti, end;] , return the minimum number
    of conference rooms required.


    Example 1:
    Input: intervals = [[0,30], [5,10], [15,20]]

    Output: 2
    Example 2:
    Input: intervals = [[7,10],[2,4]]
    Output: 1

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms_II_253 {

    public int minMeetingRooms(int[][] intervals){

        //Sort array by the start time
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        //min heap to keep track of the end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Keep first meeting's end time
        minHeap.add(intervals[0][1]);

        //find min rooms
        for(int i = 1; i< intervals.length; i++){
            int[] runningMeeting = intervals[i];
            //previous meeting's end time < running meeting's start time
            if(minHeap.peek()<=runningMeeting[0]){
                minHeap.poll();
            }
            //where wise keep running meeting in heap
            minHeap.add(runningMeeting[1]);
        }

        //return minimum meeting rooms
        return minHeap.size();
    }

}
