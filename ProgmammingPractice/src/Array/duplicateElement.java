package Array;

public class duplicateElement {
	
	public static void main(String[] args) {
		
		int[] arr =new int[] {1,2,3,2,4,3,5,6,1,5,9,8,7};
		
		System.out.print("Duplicate elements in given array: ");  
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
					System.out.print(arr[j]+ " ");
			}
		}
	}

}
