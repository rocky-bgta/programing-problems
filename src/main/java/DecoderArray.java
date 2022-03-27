
public class DecoderArray
{

	public static void main(String[] args) 
	{

		int result=0;
		result = decodeArray(new int[ ]{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1});

	}
	
	
	static int decodeArray(int[ ] a)
	{
		int count =0;
		String res="";
		int dig;
		char chadit;
		
		
		if(a.length == 1)
		{
			if(a[0]==1)
				return 0;
		}
		else
		{
			if(a[0]>-1)
			{
				for(int i=0 ; i<a.length; i++)
				{
					if(a[i]==0)
					{
						count++;
					}
					else
					{
						res=res+count;
						count=0;
					}
				}
			}
			else
			{
				for(int i=1 ; i<a.length; i++)
				{
					if(a[i]==0)
					{
						count++;
					}
					else
					{
						res=res+count;
						count=0;
					}
				}
			}
		}
		dig = Integer.parseInt(res);
		if(a[0]==-1)
			return dig*a[0];
		else
			return dig;
		
	}
}
