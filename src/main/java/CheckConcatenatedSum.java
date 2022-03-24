
public class CheckConcatenatedSum {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//checkConcatenatedSum(198,2);
//		checkConcatenatedSum(198,3);
//		checkConcatenatedSum(2997,3);
//		checkConcatenatedSum(2997,2);
//		checkConcatenatedSum(13332,4);
		checkConcatenatedSum(9,1);
		

	}
	
	static int checkConcatenatedSum(int n, int catlen)
	 {
		int dig=0,concat=1,numCon=0;
		int sum=0,orgnial=n;
		int conSum=0;
		
		while(n>0)
		{
			dig = n%10;
			n=n/10;
			
			while(numCon!=catlen-1)
			{
				concat*=10;
				numCon++;
				conSum+=(concat*dig);
			}
			
			conSum+=dig;
			sum+=conSum;
			concat=1;
			numCon=0;
			conSum=0;
		}
		
		if(orgnial==sum)
			return 1;
		else
			return 0;
	 }

}
