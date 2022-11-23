package algorithms.sorting.merge_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortAlgorithm {

    public void mergeSort(int[] a, int lb, int ub){
        int mid;
        if(lb< ub){
            mid = (lb+ub)/2;

            mergeSort(a,lb,mid); // actually divide array until it reach to single element first half
            mergeSort(a,mid+1,ub); // actually divide array until it reach to single element second half
            //merge(a,tempMid,tempLb,tempUb);
        }

    }

    public void merge(int a[], int lb, int mid, int ub){
        int i = lb;
        int j = mid + 1;
        int k = lb;
        int[] b = new int[lb+ub];

        while (i<=mid && j<=ub){
            if(a[i]<=a[j]){
                b[k] = a[i];
                i++;
            }else {
                b[k] = a[j];
                j++;
            }
            k++;
        }

        if(i>mid){
            while (j<=ub){
                b[k]=a[j];
                j++;
                k++;
            }
        }else {
            while (i<=mid){
                b[k] = a[i];
                i++;
                k++;
            }
        }

        for(int m=lb; m<=ub; m++){
            a[m]=b[m];
        }
    }



//    /** mergeSort function */
//    public List<Integer> mergeSort(List<Integer> array) {
//        if (array.size() == 1) {
//            return array;
//        }
//
//        List<Integer> left = array.subList(0, array.size() / 2);
//        List<Integer> right = array.subList(array.size() / 2, array.size());
//
//        return merge(mergeSort(left), mergeSort(right));
//    }
//
//    /** merge function */
//    public List<Integer> merge(List<Integer> left, List<Integer> right) {
//        ArrayList<Integer> result = new ArrayList<>();
//        int leftIndex = 0;
//        int rightIndex = 0;
//
//        while (leftIndex < left.size() && rightIndex < right.size()) {
//            if (left.get(leftIndex) < right.get(rightIndex)) {
//                result.add(left.get(leftIndex));
//                leftIndex++;
//            } else {
//                result.add(right.get(rightIndex));
//                rightIndex++;
//            }
//        }
//        List<Integer> leftRemaining = left.subList(leftIndex, left.size());
//        List<Integer> rightRemaining = right.subList(rightIndex, right.size());
//
//        result.addAll(leftRemaining);
//        result.addAll(rightRemaining);
//
//        return result;
//    }
//
    public static void main(String[] args) {
        MergeSortAlgorithm mergeSortAlgorithm = new MergeSortAlgorithm();
        //ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        int arr[] = {15, 5, 24,8,1,3,16,10,20};
        mergeSortAlgorithm.mergeSort(arr, 0, arr.length );
        int mid = (0+arr.length)/2;
        mergeSortAlgorithm.merge(arr,0,mid, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
