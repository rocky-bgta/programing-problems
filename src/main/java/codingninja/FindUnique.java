package codingninja;

/*
    https://www.codingninjas.com/studio/problems/find-unique_625159?source=youtube&campaign=love_babbar_codestudio1&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio1


    Explanation: https://www.youtube.com/watch?v=oVa8DfUDKTw&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=11
    Time slot: 25:00

 */
public class FindUnique {


    public static void main(String[] args) {
        int arr[]={2, 3, 1, 6, 3, 6, 2};
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr){
        //Your code goes here
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            ans^=arr[i];
        }
        return ans;

    }
}
