import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
	
	/*
	 * Complete the 'groupTransactions' function below.
	 *
	 * The function is expected to return a STRING_ARRAY.
	 * The function accepts STRING_ARRAY transactions as parameter.
	 */
	
	public static List<String> groupTransactions(List<String> transactions) {
		List<String> sortedTransaction = new ArrayList<>();
		sortedTransaction = transactions.stream().sorted().collect(Collectors.toList());
		int transactionCount = 0;
		String itemWithTransaction;
		List<String> result = new ArrayList<>();
		
		for (String string1 : sortedTransaction) {
			for (String string2 : sortedTransaction) {
				if(string1.equals(string2)){
					transactionCount++;
				}
			}
			itemWithTransaction = string1 + " "+transactionCount;
			transactionCount = 0;
			result.add(itemWithTransaction);
		}
		
		return sortedTransaction;
		
	}
	
}
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		
		int transactionsCount = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<String> transactions = IntStream.range(0, transactionsCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
			                            .collect(toList());
		
		List<String> result = Result.groupTransactions(transactions);
		bufferedWriter.write(
			result.stream()
				.collect(joining("\n"))
				+ "\n"
		);
		
		bufferedReader.close();
		bufferedWriter.close();
	}
}
