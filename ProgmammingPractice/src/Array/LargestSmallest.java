package Array;

public class LargestSmallest {

	public static void main(String[] args) {

		int[] arr = new int[] { 2, 4, 2, 56, 76, 89, 23, 45,1 };
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println("Largest element present in given array: " + max);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		System.out.println("Largest element present in given array: " + min);
	}

}
