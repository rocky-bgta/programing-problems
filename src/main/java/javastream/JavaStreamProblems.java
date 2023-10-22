package javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamProblems {


    public static void main(String[] args) {

        //Find the maximum number
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,9,5);
        Integer max = numbers.stream().max((i,j)->i.compareTo(j)).get();

        System.out.println(max);


        //Find even number grater then 5
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.stream().filter(x->(x%2==0 && x>5)).collect(Collectors.toList());
    }
}
