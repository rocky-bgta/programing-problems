import java.io.*;
import java.util.Arrays;

class Result1 {
	
	/*
	 * Complete the 'superReducedString' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static Double addValues (Double[] values) {
		Double result=0d;
		for(int i=0; i<values.length; i++){
			if(values[i]==null){
				return null;
			}else{
				result += values[i];
			}
		}
		// return the total
		return result;
	}
	
	public static String superReducedString(String s) {
		// Write your code here
		String result="";
		int count=0;
		char a, b;
		int index=0;
		
		for(int i=0; i<s.length(); i++){
			a = s.charAt(i);
			s = s.replaceAll(String.valueOf('a'),"");
			
			for(int j=0; j<s.length(); j++){
				b = s.charAt(j);
				if(a==b){
					count++;
					index = j;
				}
			}
			
			if(count%2==1){
				result+=a;
			}
			count = 0;
			s=s.substring(index);

		}
		
		if(result.length() == 0)
			result = "Empty String";
		
		return result;
	}
}

public class SuperReducedString {
	
	public static void main(String[] args) throws IOException {
	
		String simple ="aaabccddd";
		Result1.superReducedString(simple);
		
	
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		String s = bufferedReader.readLine();
//
//		String result = Result.superReducedString(s);
//
//		bufferedWriter.write(result);
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();
	}
}
