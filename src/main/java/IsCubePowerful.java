public class IsCubePowerful {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isCubePowerful(153);
		isCubePowerful(370);
		isCubePowerful(371);
		
		isCubePowerful(407);
		isCubePowerful(87);
		isCubePowerful(0);
		isCubePowerful(-81);

	}
	
	static int isCubePowerful(int n)
	{
		int sum=0,dig,org=n;
		if(n>0) {
			while (n != 0) {
				dig = n % 10;
				n = n / 10;

				sum += dig * dig * dig;
			}

			if (sum == org)
				return 1;
			else
				return 0;
		}
		else
			return 0;
	}

}
