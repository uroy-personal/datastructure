package practice.geeksforgeeks.array;

import java.util.ArrayList;

public class SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subarraySum(new int[] {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134}, 42, 468));
	}
	
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int windowStart =0;
        int windowEnd =1;
        int windowSum = 0;
        ArrayList<Integer> result =null;
        
        for(windowEnd=0;windowEnd<arr.length;windowEnd++){
            
        	windowSum+=arr[windowEnd];
            
        	while(windowSum>s){
                windowSum-=arr[windowStart];
                windowStart++;
            }
            
            if(windowSum==s){
            	result = new ArrayList<Integer>();
                result.add(windowStart+1);
                result.add(windowEnd+1);
                break;
            }
            
        }
        if(result==null) {
        	result = new ArrayList<Integer>();
        	result.add(-1);
        }
        return result;
    }

}
