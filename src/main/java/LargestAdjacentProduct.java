
public class LargestAdjacentProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//largestAdjacentSum(new int[ ] {1, 2, 3, 4});
		
		//largestAdjacentSum(new int[ ] {18, -12, 9, -10});
		
		//largestAdjacentSum(new int[ ] {1,1,1,1,1,1,1,1,1});
		
		//largestAdjacentSum(new int[ ] {1,1,1,1,1,2,1,1,1});

		/*
		Input:
		inputArray: [3, 6, -2, -5, 7, 3]
		Output:
		10
		Expected Output:
		21
	    */

		largestAdjacentSum(new int[ ] {3, 6, -2, -5, 7, 3});
	}
	
	static int largestAdjacentSum(int[ ] inputArray)
	{
		int max=-99999,sum=0;

		for(int i=1; i<inputArray.length; i++)
		{
			sum = inputArray[i] + inputArray[i-1];
			if(sum>max)
				max=sum;
		}

		return max;

//		Integer max = Integer.MIN_VALUE;
//		for (int i = 1; i < inputArray.length; i++) {
//			System.out.println("Product value: "+ inputArray[i] * inputArray[i - 1]);
//
//			max = Math.max(inputArray[i] * inputArray[i - 1], max);
//		}

		//return max;
	}





}
