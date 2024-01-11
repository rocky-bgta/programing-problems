package wellDev;


import java.util.*;


public class Solution {
    public static void process(List<? extends Number> list){
    //public static void process(List<Number> list) {
        double sum = 0;
        for (Number number : list)
            sum += number.doubleValue();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 20);
        List<Double> doubleList = Arrays.asList(1.5, 2.5);
        List<Number> numberList = Arrays.asList(5, 2, 2.6f, 5.9f);

        Solution.process(intList);
        Solution.process(doubleList);
        Solution.process(numberList);
    }
}