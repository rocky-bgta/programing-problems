package algorithms.sorting.selection_sort;

import java.util.Arrays;

/*
    Animation
    https://www.youtube.com/watch?v=nmhjrI-aW5o

    https://www.youtube.com/watch?v=9oWd4VJOwr0&t=522s
 */
public class SelectionSort {
    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }

            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        SelectionSort sort = new SelectionSort();
        System.out.println(Arrays.toString(sort.selectionSort(numbers)));
    }
}
