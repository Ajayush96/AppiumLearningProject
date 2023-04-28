package Array;

public class ReverseArray {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,4,3,5,6,7,1};
		
		System.out.print("Reverse array will be: ");
		for(int i=arr.length-1;i>=0;i--)
		{
			System.out.print(arr[i] + " ");
		}

	}

}
