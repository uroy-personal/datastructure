package practice.walmartlabs;

import java.util.*;


public class LongestConsecutiveSubsequence {
	
	public static int findLongestConseqSubseq(int arr[], int N)
	{
	    Set<Integer> uniqueElements =  new HashSet<Integer>(); 
		int logestSubSequenceLength=0;
	    for(int arrayElement: arr) {
			uniqueElements.add(arrayElement);
		}
		
	    for(int i=0;i<N;i++) {
			
		 if(!uniqueElements.contains(arr[i]-1)) {
			 int j = arr[i];
			 while(uniqueElements.contains(j)) {
				 j++;
			 }
			 
			 logestSubSequenceLength = Math.max(logestSubSequenceLength, j-arr[i]);
		 }
		 
		}
	    
	   return logestSubSequenceLength;
	}
	public static void main(String[]args) {
		System.out.println(findLongestConseqSubseq(new int[] {2,6,1,9,4,5,3}, 7));
	}
}
