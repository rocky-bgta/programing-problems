public class ClosestFibonacci {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//closestFibonacci(13);
		closestFibonacci(10);

	}
	
	static int closestFibonacci(int n)
	{
		int i=1,j=1,k=0,closeFib=0;
		if(n<1)
			return 0;
		else
		for(int l=0; l<n; l++)
		{
			k=i+j;
			j=i;
			i=k;
			if(k<=n)
				closeFib=k;
			else
				break;
		}
		
		return closeFib;
	}

}
