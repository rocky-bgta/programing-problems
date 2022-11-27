package dsa.algorithms.sorting.insertion_sort;

import java.util.Arrays;

//https://www.youtube.com/watch?v=yCxV0kBpA6M
public class InsertionSort {
    public int[] insertionSort(int[] a ) {

        for(int i=1; i<a.length; i++){
            int temp = a[i];
            int j = i-1; //

            while (j>=0 && a[j]>temp){
                a[j+1] = a[j];              // insert item at proper place of sorted list
                j--;
            }
            a[j+1] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        InsertionSort mySort = new InsertionSort();
        System.out.println(Arrays.toString(mySort.insertionSort(numbers)));
    }
}
