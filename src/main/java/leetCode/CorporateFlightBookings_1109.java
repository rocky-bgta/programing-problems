package leetCode;

/*
    https://leetcode.com/problems/corporate-flight-bookings/description/
 */

public class CorporateFlightBookings_1109 {
    public static void main(String[] args) {
       int booking[][]= {{1,2,10},{2,3,20},{2,5,25}};
               int n = 5;
       corpFlightBookings(booking,n);
    }
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        
        // Initialize the answer array with 0
        for (int i = 0; i < n; i++) {
            answer[i] = 0;
        }


        /*
        This loop iterates through the bookings array,
        where each booking is represented as an array [first, last, seats].
        For each booking, it increments the number of booked seats for the
        starting flight (first - 1 because array indices start from 0) and decrements
        the number of booked seats for the flight after the ending flight (last).
        This step ensures that we are adding booked seats for the correct flights and subtracting
        them for the flights after the ending flight.
         */


        // Update the answer array based on bookings
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            
            // Increment the number of booked seats for the starting flight
            answer[first - 1] += seats;
            
            // Decrement the number of booked seats for the flight after the ending flight
            if (last < n) {
                answer[last] -= seats;
            }
        }

        /*
            After updating the answer array, we calculate the prefix sum.
            The prefix sum operation involves updating each element of the
            answer array with the sum of all previous elements.
            This step ensures that answer[i] contains the total number of booked seats for flights from 1 to i + 1.
         */
        
        // Calculate prefix sum to get the cumulative booked seats for each flight
        for (int i = 1; i < n; i++) {
            answer[i] += answer[i - 1];
        }
        
        return answer;
    }
}
