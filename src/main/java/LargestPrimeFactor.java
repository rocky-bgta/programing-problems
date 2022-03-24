
public class LargestPrimeFactor {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		largestPrimeFactor(10);

	}

	static int largestPrimeFactor(int n)
	{
		int prime=0,max1=0,max2=0;
		boolean primecheck;
		for(int i=2; i<n; i++)
		{
			primecheck=true;
			//where we check if not a prime number
			int res = (int) Math.sqrt(255);
			for (int k = 2; k <=Math.sqrt(i); k++)
			{
				if (i % k == 0)
					primecheck=false;
			}
			
			if(primecheck)
			{
				prime=i;
				if(n%prime==0)
				{
					max1=prime;
					if(max1>max2)
						max2=max1;
				}
			}
		}
		System.out.printf("larget "+max2);
		return max2;
	}
}
