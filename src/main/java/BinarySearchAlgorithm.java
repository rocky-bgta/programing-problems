public class BinarySearchAlgorithm {


    public static void main(String[] args) {

        int array [] = {10,12,20,30,35,40,50,60,70};
      int resutlt =  binarySearch(array,30);
        System.out.printf(String.valueOf(resutlt));


    }

    private static int binarySearch(int array[], int search){

        int start=0, end = array.length-1;
        int mid;
        while (start<=end){
            mid = (start+end)/2;

            if(array[mid]==search)
                return mid;
            else if(array[mid]>search)
                end=mid-1;
            else start = mid+1;
        }



        return -1;

    }


}
