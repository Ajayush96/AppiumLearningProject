package Array;

public class FrequencyOfElement {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,8,3,3,2,2,5,1,8,1};
		
		int[] frr = new int[arr.length];
		
		int visited = -1;  
		for(int i=0;i<arr.length;i++)
		{
			int count =1;
			
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j]) {
					count ++;
					frr[j] = visited;
				}
		
			}
			if(frr[i] != visited)  
				frr[i] = count; 
			
		}
		
		//Displays the frequency of each element present in array  
        System.out.println("---------------------------------------");  
        System.out.println(" Element | Frequency");  
        System.out.println("---------------------------------------");  
        for(int i = 0; i < frr.length; i++){  
            if(frr[i] != visited)  
                System.out.println("    " + arr[i] + "    |    " + frr[i]);  
        }  
        System.out.println("----------------------------------------");  

   }
}
