package String;

public class CountChar {

	public static void main(String[] args) {

		String str = "This is my sweet home";

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				count++;

		}
         
		System.out.println("Total number of characters in a string: " + count);  
	}

}
