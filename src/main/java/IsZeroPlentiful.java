public class IsZeroPlentiful {


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int result;
		//isZeroPlentiful(new int[ ]{0, 0, 0, 0, 0});
		//isZeroPlentiful(new int[ ]{1, 2, 0, 0, 0, 0, 2, -18, 0, 0, 0, 0, 0, 12});
		//isZeroPlentiful(new int[ ]{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0});
		//isZeroPlentiful(new int[ ]{1, 2, 3, 4});
		//isZeroPlentiful(new int[ ]{1, 0, 0, 0, 2, 0, 0, 0, 0});
		result = isZeroPlentiful(new int[ ]{1, 2, 0, 0, 0, 0, 2, -18, 0, 0, 0, 0, 0, 12});
		System.out.println(result);
	}

	static int isZeroPlentiful(int[ ] a)
	{
		int count=0,sec=0;
		boolean check=false;
		for(int i=0; i<a.length; i++)
		{
			if(a[i]==0)
			{
				while(a[i]==0)
				{
					count++;
					check=true;
					if(i<a.length-1)
						i++;
					else
						break;
				}
				//i--;
			}

			if(check)
			{
				if(count<4)
				{
					return 0;
				}
				else
				{
					sec++;
					check=false;
					count=0;
				}
			}

		}

		if(sec!=0)
			return sec;
		else
			return 0;
	}

}
