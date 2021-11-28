package practice.cyclicsort;

import java.util.Arrays;

public class FirstSmallestMissingPositive {
	  public static int findNumber(int[] nums) {
		    // TODO: Write your code here
		    int i=0;
		    System.out.println("Before swap :::: "+Arrays.toString(nums));
		    while(i<nums.length) {
		    	if(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]) {
		    		
		    		swap(nums, i, nums[i]-1);
		    	}else {
		    		i++;
		    	}
		    }
		    System.out.println("After swap :::: "+Arrays.toString(nums));
		    
		    for (i = 0; i < nums.length; i++)
		        if (nums[i] != i + 1)
		          return i + 1;

		      return nums.length + 1;
		    
		    
		  }
	  public static void main(String[]args) {
		  System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
		  //System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
		  //System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
	  }
	  
		public static void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
}
