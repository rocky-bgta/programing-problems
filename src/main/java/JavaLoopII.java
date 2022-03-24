import java.util.Scanner;

public class JavaLoopII {
	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int result = 0;
		int taken = 1;
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			
			
			for (int j = 1; j <= n; j++) {
				System.out.println(Math.pow(2,0));
				System.out.println(Math.pow(2,1));
				System.out.println(Math.pow(2,2));
				
				result += a + (int) Math.pow(b, j);
				System.out.print(result + " ");
			}
			result = 0;
			
		}
		
		in.close();
	}
	
}
