package leetCode;

import java.util.HashMap;

public class Two_Sum_1 {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {

        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){

            Integer diff;
            diff = (target - numbers[i]);
            if(hash.containsKey(diff)){
                return new int[]{hash.get(diff), i};
            }

            hash.put(numbers[i], i);

        }

        return null;
    }
}
