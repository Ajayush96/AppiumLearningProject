package String;

public class Reverse {

	public static void main(String[] args) {
		
		String str = "This is your destiny";
		
		char[] string = str.toCharArray();
		
		
		
		for(int i=string.length-1;i>=0;i--)
		{
			
			System.out.print(string[i]);
		}
		
		
		

	}

}
