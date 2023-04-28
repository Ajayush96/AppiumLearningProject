package String;

public class DuplicateChar {

	public static void main(String[] args) {

		String str = "Great responsibility";
		//int count;
		char[] string = str.toCharArray();
		
		for(int i=0;i<string.length;i++)
		{
			int count=0;
			for(int j=i+1;j<string.length;j++)
			{
				if(string[i]==string[j]&&string[i] != ' ')
				{
					count++;
					 //Set string[j] to 0 to avoid printing visited character    
                    string[j] = '0';   
				}
			}
			
			  if(count > 0 && string[i] != '0')    
	                System.out.println(string[i]);   
		}

	}

}
