import java.util.ArrayList;


public class EncodeNumber {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		encodeNumber(24);
		encodeNumber(6936);
		encodeNumber(1200);
		encodeNumber(-18);
		encodeNumber(2);
		encodeNumber(6);

	}
	
	static int[ ] encodeNumber(int n)
	{
		boolean isPrime=true;
		
		int loop=n;
		int[] a= new int[100]; int j=0;
		int[] rearray;
		if(n<=1)
			return null;
		else
		{
			for(int k=2; k<loop; k++)
			{
				//prime number
				if(n==1)
					break;
				for(int i=2; i<=k/i; i++)
				{
					if(k%i==0)
						isPrime=false;
					else 
						isPrime=true;
					
				}
				if(isPrime)
				{
					while(true)
					{
						if(n%k==0)
						{
							n=n/k;
							a[j]=k;
							j++;
						}
						else
							break;
					}
				}
			}
			
			int length=j;
			rearray = new int[length];
			for(int i=0; i<length; i++)
				rearray[i]=a[i];
			
			
		}
		
		return rearray;
	}

}
