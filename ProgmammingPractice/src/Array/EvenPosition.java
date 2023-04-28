package Array;

public class EvenPosition {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,4,3,5,6,7,1,8,9};
		System.out.print("The Even position number: ");
		for(int i=0;i<arr.length;i++)
		{
			if(i%2==0)
				System.out.print(arr[i]+ " ");
		}
		
		
	   System.out.println(" ");
       System.out.println("--------");
       System.out.print(" ");
       
		System.out.print("The odd position number: ");
		for(int i=0;i<arr.length;i++)
		{
			if(i%2!=0)
				System.out.print(arr[i]+ " ");
		}
	}

}
