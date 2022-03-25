public class MatchPattern {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		matchPattern(new int[]{1, 1, 10, 4, 4, 3} , 6,new int[] {1, 4, 3} , 3);
		matchPattern(new int[]{1, 1, 1, 2, 2, 1, 1, 3}, 8,new int[] {1, 2, 1, 3}   ,4);
	}

	static int matchPattern(int[] a, int len, int[] pattern, int patternLen) {
		// len is the number of elements in the array a, patternLen is the
		// number of elements in the pattern.
		
		int i = 0; // index into a
		int k = 0; // index into pattern
		
		int matches = 0; // how many times current pattern character has been
							// matched so far
		int ak,bk;
		for (i = 0; i < len; i++) 
		{
			if (a[i] == pattern[k])
				matches++; // current pattern character was matched
			
			else
			{//have to remove
				if (matches == 0 || k == patternLen - 1)
					return 0; // if pattern[k] was never matched (matches==0) or at
									// end of pattern (k==patternLen-1)
				else // advance to next pattern character
				{
					// !!You write this code!!
					if(k!=patternLen-1)
					{
						k++;
						if(i!=len-1)
						{
							ak=a[i];bk=pattern[k];
							if(ak!=bk)
								return 0;
						}
						if(a[i+1]!=pattern[k])
							return 0;
					}
					
					
				} // end of else
			}//have to remove
		} // end of for
		
		
			// return 1 if at end of array a (i==len) and also at end of pattern
			// (k==patternLen-1)
		if (i == len && k == patternLen - 1)
			return 1;
		else
			return 0;
	}
}
