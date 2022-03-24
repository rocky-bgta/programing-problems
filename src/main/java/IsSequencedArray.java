
public class IsSequencedArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isSequencedArray(new int[]{1, 2, 3, 4},1,5);
		isSequencedArray(new int[]{1, 2, 3, 4, 5},1,5);
		isSequencedArray(new int[]{1, 3, 4, 2, 5},1,5);
		isSequencedArray(new int[]{-5, -5, -4, -4, -4, -3, -3, -2, -2, -2},-5,-2);
		isSequencedArray(new int[]{0, 1, 2, 3, 4, 5},1,5);

	}

	static int isSequencedArray(int[ ] a, int m, int n)
	{
		int res=0;
		for(int i=0; i<a.length; i++)
		{
				if(a[i]>=m && a[i]<=n)
				{
					if(i<a.length-1)
						if((a[i]>a[i+1]))
						{
							//res=0;
							return 0;
						}
				}
				else
					return 0;
		}
		//check is m and n included in array
		for(int i=m; i<=n; i++)
		{
			for(int j=0; j<a.length; j++)
			{
				if(i==a[j])
				{
					res=1;
					break;
				}
				else
					res=0;
			}
			
		}
		
		return res;
	}
}
