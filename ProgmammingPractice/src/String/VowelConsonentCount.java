package String;

public class VowelConsonentCount {

	public static void main(String[] args) {
		
		String str = "Darbhanga aeiou z is my hometown";
		
		int v=0;
		int c=0;
		
	str.toLowerCase();
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
			{
				v++;	
			}
			if(str.charAt(i)>='a'&& str.charAt(i)<='z')
			{
				c++;;
			}
		  
		}
		
        System.out.println("Number of vowels: " + v);    
        System.out.println("Number of consonants: " + c); 
	}

}
