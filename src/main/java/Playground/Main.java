package Playground;

//Here is the optimized Java code to solve the problem you described with the input `int[] category = {3, 1, 2, 3}; int[] price = {2, 1, 4, 4};`:

//```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 4;
        int[] category = {3, 1, 2, 3};
        int[] price = {2, 1, 4, 4};
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> {
            if (price[(int) a] != price[(int)b]) {
                return Integer.compare(price[(int)b], price[(int)a]);
            }
            return Integer.compare(category[(int)a], category[(int)b]);
        });
        long profit = 0;
        Set<Integer> categories = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int item = order[i];
            categories.add(category[item]);
            profit += (long) price[item] * categories.size();
        }
        System.out.println(profit);
    }
}
//```
//
//This code uses a greedy algorithm to find the maximum possible total profit that can be made by selling the items in the optimal order. It sorts the items by their price in descending order and then by their category in ascending order. Then, it iterates over the sorted items and calculates the profit for each item based on the number of different categories whose items have been sold before (including this item's category). It keeps track of the total profit and returns it at the end.
//
//I hope this helps!.
//
//Source: Conversation with Bing, 12/1/2023
//(1) Java Examples | Programiz. https://www.programiz.com/java-programming/examples.
//(2) Java Programs - Java Programming Examples with Output - BeginnersBook. https://beginnersbook.com/2017/09/java-examples/.
//(3) Java Programs - Java Programming Examples - GeeksforGeeks. https://www.geeksforgeeks.org/java-programming-examples/.
//(4) Top 100+ Java Programming Examples With Output. https://www.knowprogram.com/java-programming-examples/.
//(5) Java Examples - W3Schools. https://www.w3schools.com/java/java_examples.asp.
//(6) Getty Images. https://www.gettyimages.com/detail/photo/java-programming-concept-virtual-machine-on-server-royalty-free-image/1131109259.