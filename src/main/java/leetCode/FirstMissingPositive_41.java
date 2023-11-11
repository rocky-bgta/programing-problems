package leetCode;

/*
    https://leetcode.com/problems/first-missing-positive/description/

    Explanation video:
    https://www.youtube.com/watch?v=DhdS_jHF_q4&t=322s
 */

public class FirstMissingPositive_41 {

    public static void main(String[] args) {
        int[] input={4,3,2,5};
        //int[] input={3,4,-1,1};

        //int[] input={7,8,9,11,12};
        missingNumber(input);
    }
    public static int missingNumber(int arr[]){
        int size = arr.length;
        for(int i=0; i<size; i++){    //array= [1,2,3,4]
            int currIndex = arr[i]-1; //index=  0 1 2 3  ** that is always actual array value keep at previous index
            while ((0<=currIndex && currIndex <= size-1) && (arr[i]!=arr[currIndex])){
                int temp = arr[i];
                arr[i]=arr[currIndex]; /* this loop place the current index value to it's right position of array */
                arr[currIndex] = temp;
                currIndex = arr[i]-1; // after placing value at correct position
            }
        }

        for(int i=0; i<size; i++){ // check if missing number is discovered by adding 1 to index
            if(arr[i]!=i+1)
                return i+1;
        }

        return size+1; // if not then array length + 1  will be the missing smallest number
    }

}
