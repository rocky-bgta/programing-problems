public class AreAnagrams {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		areAnagrams(new char [ ]{'s', 'i', 't'} ,new char [ ]{'i', 't', 's'});
	//	areAnagrams(new char [ ]{'b', 'o', 'g'} ,new char [ ]{'b', 'o', 'o'});
		areAnagrams(new char [ ]{} ,new char [ ]{});

	}

	static int areAnagrams(char [ ] a1, char [ ] a2)
	{
		
		char[] temA2 = new char[a2.length]; 
		char comChar;
		boolean check=false;
		if(a1.length!=a2.length)
			return 0;
		else
		{
			//copy char array
			for(int i=0; i<a2.length; i++)
			{
				temA2[i]=a2[i];
			}
			
			for(int i=0; i<a1.length; i++)
			{
				comChar=a1[i];
				for(int j=0; j<a2.length; j++)
				{
					if(comChar==temA2[j])
					{
						check=true;
						temA2[j]=' ';
						break;
					}
					else
						check=false;
				}
				
				if(check==false)
				{
					return 0;
				}
			}
		}
		
		return 1;
	}
}
