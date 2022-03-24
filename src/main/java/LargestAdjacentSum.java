
public class LargestAdjacentSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		largestAdjacentSum(new int[ ] {1, 2, 3, 4});
		
		largestAdjacentSum(new int[ ] {18, -12, 9, -10});
		
		largestAdjacentSum(new int[ ] {1,1,1,1,1,1,1,1,1});
		
		largestAdjacentSum(new int[ ] {1,1,1,1,1,2,1,1,1});
	}
	
	static int largestAdjacentSum(int[ ] a)
	{
		int max=-99999,sum=0;
		
		for(int i=0; i<a.length-1;)
		{
			if(i<a.length)
			sum=a[i]+a[++i];
			
			if(sum>max)
				max=sum;
		}
		
		return max;
	}

}
